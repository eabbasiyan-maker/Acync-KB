#!/usr/bin/env python3
"""Read-only unit tests for source registry and two HISTORICAL samples.
No network, no service calls, no source or config changes.
"""
import unittest, csv, json, pathlib, re, collections, os
from validate_historical import evaluate
ROOT=pathlib.Path(os.getenv('ASYNC_SOURCE_DIR','/mnt/data/async_pm/source'))
ART=pathlib.Path(os.getenv('ASYNC_REGISTRY_CSV','/mnt/data/observability_registry/all-log-point-cards.csv'))
STR=pathlib.Path(os.getenv('ASYNC_STRUCTURED_SAMPLE','/mnt/data/async_json-arash.LOG.log'))
TXT=pathlib.Path(os.getenv('ASYNC_TEXTUAL_SAMPLE','/mnt/data/async-arash.LOG.log'))

class RegistryQuality(unittest.TestCase):
 @classmethod
 def setUpClass(cls):
  with ART.open(encoding='utf-8-sig',newline='') as f:
   cls.rows=list(csv.DictReader(f))
  cls.hist=evaluate(STR,TXT)
 def test_01_coverage_count(self):self.assertEqual(len(self.rows),956)
 def test_02_unique_log_ids(self):self.assertEqual(len({r['log_id'] for r in self.rows}),956)
 def test_03_legacy_953_reconciled(self):self.assertEqual(sum(r['included_in_prior_953_inventory']=='True' for r in self.rows),953)
 def test_04_all_source_paths_and_line_numbers_resolve(self):
  for r in self.rows:
   p=ROOT/r['source_path'];self.assertTrue(p.is_file(),r['log_id']);line=p.read_text(encoding='utf-8',errors='replace').splitlines()[int(r['source_line'])-1]
   self.assertRegex(line,rf'\.{r["level"].lower()}\s*\(',r['log_id'])
 def test_05_vendor_and_method_unknown(self):
  self.assertEqual(sum(r['source_path'].startswith('src/org/') for r in self.rows),18)
  self.assertEqual(sum(r['method_name']=='UNKNOWN_REQUIRES_REVIEW' for r in self.rows),12)
 def test_06_static_routing_unverified_majority(self):self.assertGreaterEqual(sum(r['route_status']=='UNVERIFIED_ROUTE' for r in self.rows),900)
 def test_07_missing_trigger_claims_are_explicit(self):
  self.assertGreaterEqual(sum('UNKNOWN' in r['trigger_condition'] for r in self.rows),900)
 def test_08_historical_record_counts_and_windows(self):
  v=self.hist;self.assertEqual(v['sources'][0]['count'],15592);self.assertEqual(v['sources'][1]['count'],17072);self.assertNotEqual(v['sources'][0]['start_utc'],v['sources'][1]['start_utc'])
 def test_09_before_after_pairing_is_not_ack(self):
  v=self.hist['before_after_pairs'];self.assertEqual((v['paired'],v['unpaired_before'],v['unpaired_after']),(6685,0,1))
 def test_10_http_timeout_join_alias(self):
  t=self.hist['timeout_correlation'];self.assertEqual(t['matched_to_408'],28);self.assertEqual(t['http_408_total'],150)
 def test_11_negative_duration_not_false_latency(self):
  q=self.hist['duration_quality'];self.assertEqual(q['negative_after_send_time'],726);self.assertEqual(q['negative_service_client_time'],569)
 def test_12_source_only_risk_not_ruled_out_by_absence(self):
  self.assertEqual(self.hist['textual_signatures']['db_threadpool_threshold'],0)
  code=(ROOT/'src/com/nozha/async/server/persistance/MessageCRUD.java').read_text()
  self.assertIn('executorService.getTaskCount() > Settings.ASYNC_SAVE_MESSAGE_THREAD_POOL_TASK_SIZE',code)
 def test_13_database_and_broker_signatures(self):
  q=self.hist['textual_signatures'];self.assertEqual(q['addClient_ora00001'],100);self.assertEqual(q['invalid_queue_name'],118)
 def test_14_historical_missing_class_quantified(self):
  n=0
  with TXT.open(encoding='utf-8') as f:
   for line in f:
    r=json.loads(line);clazz=(r.get('source') or {}).get('class','')
    if clazz=='com.nozha.async.server.activemq.classic.EmbeddedBroker':n+=1
  self.assertEqual(n,4032)
  self.assertFalse((ROOT/'src/com/nozha/async/server/activemq/classic/EmbeddedBroker.java').exists())
 def test_15_event_types_are_snapshot_scoped(self):
  self.assertEqual(self.hist['structured_types'],{'BeforeSendLog':6685,'AfterSendLog':6686,'ServiceTimeLog':2221})
 def test_16_latency_spikes_are_numeric_observations(self):
  self.assertEqual(self.hist['latency']['http408_119s_to_121s'],146);self.assertEqual(self.hist['latency']['http500_29s_to_31s'],49)
 def test_17_no_sensitive_identifiers_in_json_report(self):
  s=json.dumps(self.hist);self.assertIn('HISTORICAL_SAMPLE_ONLY_NOT_CURRENT_PRODUCTION',s)
  self.assertNotIn('messagePreview',s);self.assertNotIn('peerId=',s);self.assertNotIn('Bearer ',s)

if __name__=='__main__':unittest.main(verbosity=2)