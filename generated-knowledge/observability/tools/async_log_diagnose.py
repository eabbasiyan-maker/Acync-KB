#!/usr/bin/env python3
"""Privacy-preserving, READ-ONLY Async two-stream log diagnostic summary.

No raw record, identifier, address, preview or payload is ever exported. This
analyzer emits historical/current SAMPLE evidence, never production RCA claims.
Requires Python 3.9+ and only the standard library.
"""
from __future__ import annotations
import argparse
import collections
import datetime as dt
import hashlib
import json
import pathlib
import re

TIMEOUT = re.compile(r"\bhttp request onTimeout\b", re.I)
TRACKER = re.compile(r"\btrackerId\s*[=:]\s*(\d+)", re.I)
ORA1 = re.compile(r"ORA-00001\b", re.I)
ALLOWED_STATUSES = {"200", "201", "301", "400", "401", "404", "408", "429", "451", "500", "502", "503", "504"}

def time_of(row: dict) -> float | None:
    instant = row.get("instant")
    if not isinstance(instant, dict):
        return None
    try:
        return float(instant["epochSecond"]) + float(instant.get("nanoOfSecond", 0)) / 1e9
    except (KeyError, ValueError, TypeError):
        return None

def as_str(v: object) -> str:
    return "" if v is None else str(v)

def host_of(row: dict) -> str:
    return as_str(row.get("hostname"))

def safe_int_lt_zero(v: object) -> bool:
    try:
        return float(v) < 0
    except (ValueError, TypeError):
        return False

def read_jsonl(path: pathlib.Path):
    sha = hashlib.sha256()
    with path.open("rb") as fh:
        for line_number, raw in enumerate(fh, 1):
            sha.update(raw)
            if not raw.strip():
                continue
            try:
                row = json.loads(raw)
            except (UnicodeDecodeError, json.JSONDecodeError) as e:
                # Never echo raw input because it may contain secrets.
                raise ValueError(f"Invalid JSON record at line {line_number}") from e
            if not isinstance(row, dict):
                raise ValueError(f"Expected JSON object at line {line_number}")
            yield row
    # Hash is computed in caller separately to avoid exposing content.

def sha256(path: pathlib.Path) -> str:
    h = hashlib.sha256()
    with path.open("rb") as f:
        for block in iter(lambda: f.read(1024 * 1024), b""):
            h.update(block)
    return h.hexdigest()

def summarize(structured_path: pathlib.Path, textual_path: pathlib.Path, tolerance_seconds: float = 120) -> dict:
    kinds, levels, statuses = collections.Counter(), collections.Counter(), collections.Counter()
    be, af, s408 = collections.Counter(), collections.Counter(), collections.defaultdict(list)
    hosts_s, hosts_t = set(), set()
    times_s, times_t = [], []
    info = collections.Counter()
    scount = tcount = 0
    for row in read_jsonl(structured_path):
        scount += 1
        host = host_of(row)
        hosts_s.add(host)
        timestamp = time_of(row)
        if timestamp is not None:
            times_s.append(timestamp)
        message = row.get("message")
        if not isinstance(message, dict):
            info["non_object_structured_message"] += 1
            continue
        name = as_str(message.get("logType")) or "UNKNOWN"
        # LogType is an identifier from code. Do not echo unfamiliar values verbatim.
        if name not in {"BeforeSendLog", "AfterSendLog", "ServiceTimeLog", "HttpLog", "ServiceCallLog", "RateLimitLog", "PODMonitoringLog", "WebsocketAddressLog", "OpenClientAddressLog"}:
            name = "UNKNOWN_OR_OTHER"
        kinds[name] += 1
        if name in ("BeforeSendLog", "AfterSendLog"):
            fields = (message.get("messageId"), message.get("trackerId"), message.get("client"))
            if any(x is None or x == "" for x in fields):
                info["send_missing_correlation_key"] += 1
            else:
                key = (host,) + tuple(as_str(x) for x in fields)
                if name == "BeforeSendLog": be[key] += 1
                else: af[key] += 1
        if name == "AfterSendLog" and safe_int_lt_zero(message.get("time")):
            info["negative_after_send_time"] += 1
        if name == "ServiceTimeLog":
            code = as_str(message.get("status"))
            statuses[code if code in ALLOWED_STATUSES else "OTHER_OR_UNKNOWN"] += 1
            if safe_int_lt_zero(message.get("clientTime")):
                info["negative_service_client_time"] += 1
            if code == "408" and timestamp is not None and message.get("lastTrackerId") is not None:
                s408[(host, as_str(message["lastTrackerId"]))].append(timestamp)
            duration = message.get("time")
            try:
                duration = float(duration)
            except (ValueError, TypeError):
                duration = -1
            if code == "408" and 119000 <= duration <= 121000: info["http408_near_120s"] += 1
            if code == "500" and 29000 <= duration <= 31000: info["http500_near_30s"] += 1
            if message.get("messagePreview") not in (None, ""):
                info["service_with_message_preview"] += 1

    timeouts = []
    for row in read_jsonl(textual_path):
        tcount += 1
        host = host_of(row)
        hosts_t.add(host)
        timestamp = time_of(row)
        if timestamp is not None: times_t.append(timestamp)
        level = as_str(row.get("level"))
        levels[level if level in {"TRACE", "DEBUG", "INFO", "WARN", "ERROR", "FATAL"} else "UNKNOWN"] += 1
        msg = row.get("message")
        if not isinstance(msg, str):
            info["text_non_string_message"] += 1
            continue
        if TIMEOUT.search(msg):
            info["text_http_onTimeout"] += 1
            match = TRACKER.search(msg)
            if match and timestamp is not None: timeouts.append((host, match.group(1), timestamp))
            else: info["timeout_missing_tracker_or_time"] += 1
        # Error signatures are fixed to prevent ever echoing user content.
        if "addClient" in msg and ORA1.search(as_str(row.get("thrown")) + msg):
            info["oracle_addClient_ora00001"] += 1
        if "invalid queue name" in msg.lower(): info["invalid_queue_name"] += 1
        if "swagger" in msg.lower(): info["swagger_related_text"] += 1
        if "Async DB ThreadPool task size more than threshold" in msg: info["db_cumulative_gate_log"] += 1
        source = row.get("source") or {}
        if isinstance(source, dict) and source.get("class") == "com.nozha.async.server.activemq.classic.EmbeddedBroker":
            info["historical_embedded_broker_class_events"] += 1

    nearest = collections.defaultdict(list)
    for (host, tracker), values in s408.items(): nearest[(host, tracker)].extend(sorted(values))
    matched_timeout = 0
    for host, tracker, timestamp in timeouts:
        candidates = nearest.get((host, tracker), [])
        viable = [t for t in candidates if abs(t-timestamp) <= tolerance_seconds]
        if viable:
            candidate = min(viable, key=lambda t: abs(t-timestamp))
            candidates.remove(candidate)
            matched_timeout += 1
    pairs = sum(min(n, af[key]) for key,n in be.items())
    def bounds(values):
        if not values: return {"start_utc": None,"end_utc":None}
        to_iso = lambda t: dt.datetime.fromtimestamp(t, dt.timezone.utc).isoformat()
        return {"start_utc":to_iso(min(values)), "end_utc":to_iso(max(values))}
    overlap = not times_s or not times_t or max(min(times_s), min(times_t)) <= min(max(times_s), max(times_t))
    # Defensive: avoid falsely calling no-timestamp inputs overlapping.
    overlap = bool(times_s and times_t and overlap)
    return {
        "classification":"SAMPLE_ONLY_NOT_CURRENT_PRODUCTION_STATUS",
        "reliability":"STATIC_LOG_SAMPLE_NO_CAUSAL_OR_DELIVERY_GUARANTEE",
        "inputs":{"structured":{"records":scount,"sha256":sha256(structured_path),"host_count":len(hosts_s),**bounds(times_s)},
                  "textual":{"records":tcount,"sha256":sha256(textual_path),"host_count":len(hosts_t),**bounds(times_t)}},
        "shared_time_window_exists":overlap,
        "types":dict(kinds),"text_levels":dict(levels),"http_status":dict(statuses),
        "send_pairing":{"matching_keys_count":pairs,"unmatched_before_count":sum((be-af).values()),"unmatched_after_count":sum((af-be).values()),"warning":"Same-key pairs are send-call attempts, not ACK; temporal ordering not established."},
        "timeout_join":{"text_timeout_events":info["text_http_onTimeout"],"eligible_with_key_and_time":len(timeouts),"joined_408_by_host_tracker_time":matched_timeout,
                        "max_lag_seconds":tolerance_seconds,"unmatched_or_unusable":info["text_http_onTimeout"]-matched_timeout},
        "signatures":{"oracle_addClient_ora00001":info["oracle_addClient_ora00001"],"invalid_queue_name":info["invalid_queue_name"],
                      "swagger_related_text":info["swagger_related_text"],"db_cumulative_gate_log":info["db_cumulative_gate_log"],
                      "historical_embedded_broker_class_events":info["historical_embedded_broker_class_events"]},
        "data_quality":{"negative_after_send_time":info["negative_after_send_time"],"negative_service_client_time":info["negative_service_client_time"],
                        "service_with_message_preview":info["service_with_message_preview"],"send_missing_correlation_key":info["send_missing_correlation_key"],
                        "non_object_structured_message":info["non_object_structured_message"],"timeout_missing_tracker_or_time":info["timeout_missing_tracker_or_time"]},
        "latency_patterns":{"http408_near_120s":info["http408_near_120s"],"http500_near_30s":info["http500_near_30s"]},
        "privacy":"Only aggregate counts and input hashes. No identifiers, addresses, payloads, raw log lines or preview content are emitted.",
        "unknowns":["deployed_version", "effective_logger_config", "kibana_ingestion", "zabbix_metrics", "business_impact", "end_to_end_ACK", "root_cause"]
    }

def main() -> int:
    ap = argparse.ArgumentParser(description="Async sampled log diagnostic (safe aggregate output)")
    ap.add_argument("structured_jsonl",type=pathlib.Path)
    ap.add_argument("textual_jsonl",type=pathlib.Path)
    ap.add_argument("--max-join-lag-sec",type=float,default=120)
    ap.add_argument("--output",type=pathlib.Path)
    args=ap.parse_args()
    if args.max_join_lag_sec < 0 or args.max_join_lag_sec>86400:
        ap.error("join lag must be between 0 and 86400 seconds")
    result=summarize(args.structured_jsonl,args.textual_jsonl,args.max_join_lag_sec)
    text=json.dumps(result,ensure_ascii=False,indent=2)+"\n"
    if args.output:
        args.output.parent.mkdir(parents=True,exist_ok=True)
        args.output.write_text(text,encoding="utf-8")
    else:print(text,end="")
    return 0
if __name__ == "__main__":
    raise SystemExit(main())