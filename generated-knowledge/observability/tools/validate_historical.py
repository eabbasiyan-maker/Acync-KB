#!/usr/bin/env python3
"""Read-only, privacy-preserving Async observability smoke-test.
Produces aggregate metrics only; never emits raw messages, IDs, addresses or payloads.
Only tests given files; DOES NOT make current-production assertions.
"""
import json, argparse, re, collections, pathlib, datetime, hashlib

def parse_jsonl(p):
    rows=[]
    with open(p,encoding='utf-8') as f:
        for i,line in enumerate(f,1):
            if not line.strip(): continue
            try: rows.append(json.loads(line))
            except json.JSONDecodeError as e: raise ValueError(f'Bad JSON line {i}') from e
    return rows

def ts(x):
    i=x.get('instant') or {}
    return float(i.get('epochSecond',0))+float(i.get('nanoOfSecond',0))/1e9

def in_band(t,low,high): return low<=t<=high

def evaluate(json_path,text_path):
    structured=parse_jsonl(json_path); textual=parse_jsonl(text_path)
    types=collections.Counter(r.get('message',{}).get('logType','UNKNOWN') for r in structured if isinstance(r.get('message'),dict))
    status=collections.Counter(str(r['message'].get('status',r['message'].get('statusCode',r['message'].get('httpStatus','UNKNOWN')))) for r in structured if isinstance(r.get('message'),dict) and r['message'].get('logType')=='ServiceTimeLog')
    def sendkey(m): return (str(m.get('messageId')),str(m.get('trackerId')),str(m.get('client')))
    be=collections.Counter(sendkey(r['message']) for r in structured if isinstance(r.get('message'),dict) and r['message'].get('logType')=='BeforeSendLog')
    af=collections.Counter(sendkey(r['message']) for r in structured if isinstance(r.get('message'),dict) and r['message'].get('logType')=='AfterSendLog')
    matched=sum(min(be[k],af[k]) for k in be)
    unpaired_before=sum((be-af).values());unpaired_after=sum((af-be).values())
    st=[r['message'] for r in structured if isinstance(r.get('message'),dict) and r['message'].get('logType')=='ServiceTimeLog']
    s408=collections.Counter(str(m.get('lastTrackerId')) for m in st if str(m.get('status'))=='408')
    timeout_re=re.compile(r'http request onTimeout\b', re.I)
    tid_re=re.compile(r'trackerId\s*[=:]\s*([0-9]+)',re.I)
    tmo_re=re.compile(r'timeout\s*[=:]\s*([0-9]+)',re.I)
    timeout=[r.get('message','') for r in textual if isinstance(r.get('message'),str) and timeout_re.search(r['message'])]
    timeout_ids=[tid_re.search(s).group(1) for s in timeout if tid_re.search(s)]
    joined=sum(min(n,s408.get(k,0)) for k,n in collections.Counter(timeout_ids).items())
    timeout_values=collections.Counter(tmo_re.search(s).group(1) for s in timeout if tmo_re.search(s))
    http408=[m for m in st if str(m.get('status'))=='408']
    http500=[m for m in st if str(m.get('status'))=='500']
    neg_after=sum(float(r['message'].get('time',0))<0 for r in structured if isinstance(r.get('message'),dict) and r['message'].get('logType')=='AfterSendLog')
    neg_client=sum(float(m.get('clientTime',0))<0 for m in st)
    messages=[r.get('message','') for r in textual if isinstance(r.get('message'),str)]
    oracle=sum('ORA-00001' in (str(r.get('thrown','')) + str(r.get('message',''))) and 'addClient' in str(r.get('message','')) for r in textual)
    invalid_queue=sum('invalid queue name' in m.lower() for m in messages)
    swagger=sum('swagger' in m.lower() for m in messages)
    threadpool=sum('Async DB ThreadPool task size more than threshold' in m for m in messages)
    counts=collections.Counter(str(r.get('level')) for r in textual)
    loghash=lambda p: hashlib.sha256(pathlib.Path(p).read_bytes()).hexdigest()
    def iso(t):return datetime.datetime.fromtimestamp(t,datetime.timezone.utc).isoformat()
    result={
        'data_classification':'HISTORICAL_SAMPLE_ONLY_NOT_CURRENT_PRODUCTION',
        'sources':[{'kind':'structured','sha256':loghash(json_path),'count':len(structured),'start_utc':iso(min(map(ts,structured))),'end_utc':iso(max(map(ts,structured)))},{'kind':'textual','sha256':loghash(text_path),'count':len(textual),'start_utc':iso(min(map(ts,textual))),'end_utc':iso(max(map(ts,textual)))}],
        'structured_types':dict(types),'text_levels':dict(counts),'http_status':dict(status),
        'before_after_pairs':{'paired':matched,'unpaired_before':unpaired_before,'unpaired_after':unpaired_after},
        'timeout_correlation':{'textual_timeout_events':len(timeout),'with_tracker_id':len(timeout_ids),'matched_to_408':joined,'timeout_values_ms':dict(timeout_values),'http_408_total':len(http408)},
        'latency':{'http408_119s_to_121s':sum(in_band(float(m.get('time',-1)),119000,121000) for m in http408),'http500_29s_to_31s':sum(in_band(float(m.get('time',-1)),29000,31000) for m in http500)},
        'duration_quality':{'negative_after_send_time':neg_after,'negative_service_client_time':neg_client},
        'textual_signatures':{'addClient_ora00001':oracle,'invalid_queue_name':invalid_queue,'swagger_message_contains':swagger,'db_threadpool_threshold':threadpool},
        'safety':'No IDs, IPs, message bodies, or raw log lines included in this output; no production inference.'
    }
    return result

if __name__=='__main__':
    ap=argparse.ArgumentParser();ap.add_argument('structured_jsonl');ap.add_argument('text_jsonl');ap.add_argument('--output'); args=ap.parse_args()
    result=evaluate(args.structured_jsonl,args.text_jsonl)
    out=json.dumps(result,ensure_ascii=False,indent=2)
    if args.output:pathlib.Path(args.output).write_text(out+'\n',encoding='utf-8')
    else:print(out)