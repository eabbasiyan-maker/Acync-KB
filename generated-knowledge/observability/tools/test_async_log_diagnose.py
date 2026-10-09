#!/usr/bin/env python3
"""Offline unit tests. No runtime network, DB, or production dependency."""
import json
import pathlib
import tempfile
import unittest
from async_log_diagnose import summarize


def event(timestamp, msg, hostname='node-test', level='INFO', source_class='test.Class'):
    whole = int(timestamp)
    return {'instant':{'epochSecond':whole,'nanoOfSecond':int((timestamp-whole)*1e9)},
            'hostname':hostname,'level':level,'source':{'class':source_class},'message':msg}


def dump(path, items):
    path.write_text(''.join(json.dumps(x)+'\n' for x in items),encoding='utf-8')

class TestAsyncLogDiagnostics(unittest.TestCase):
    def setUp(self):
        self.tmp = tempfile.TemporaryDirectory()
        self.addCleanup(self.tmp.cleanup)
        self.s = pathlib.Path(self.tmp.name)/'structured.log'
        self.t = pathlib.Path(self.tmp.name)/'text.log'
        self.base=1790000000

    def run_summary(self, ss,tt,**kwargs):
        dump(self.s,ss);dump(self.t,tt)
        return summarize(self.s,self.t,**kwargs)

    def test_pairing_and_timeout_join(self):
        t=self.base
        s=[event(t, {'logType':'BeforeSendLog','messageId':12,'trackerId':23,'client':'WebsocketClient'}),
           event(t+1,{'logType':'AfterSendLog','messageId':12,'trackerId':23,'client':'WebsocketClient','time':-2}),
           event(t+2,{'logType':'ServiceTimeLog','lastTrackerId':23,'status':408,'time':120000,'clientTime':-3})]
        txt=[event(t+2.01,'http request onTimeout peerName=test, trackerId=23, address=SECRET12345, timeout=120000')]
        out=self.run_summary(s,txt)
        self.assertEqual(out['send_pairing']['matching_keys_count'],1)
        self.assertEqual(out['timeout_join']['joined_408_by_host_tracker_time'],1)
        self.assertEqual(out['data_quality']['negative_after_send_time'],1)
        self.assertEqual(out['data_quality']['negative_service_client_time'],1)
        self.assertNotIn('SECRET12345',json.dumps(out))
        self.assertNotIn('WebsocketClient',json.dumps(out))

    def test_repeated_id_different_host_is_not_joined(self):
        t=self.base
        s=[event(t,{'logType':'ServiceTimeLog','lastTrackerId':99,'status':408},hostname='other')]
        txt=[event(t,'http request onTimeout trackerId=99',hostname='node-test')]
        out=self.run_summary(s,txt)
        self.assertEqual(out['timeout_join']['joined_408_by_host_tracker_time'],0)

    def test_same_id_far_apart_is_not_joined(self):
        t=self.base
        s=[event(t,{'logType':'ServiceTimeLog','lastTrackerId':99,'status':408})]
        txt=[event(t+3600,'http request onTimeout trackerId=99')]
        self.assertEqual(self.run_summary(s,txt)['timeout_join']['joined_408_by_host_tracker_time'],0)

    def test_one_response_cannot_pair_two_timeouts(self):
        t=self.base
        s=[event(t,{'logType':'ServiceTimeLog','lastTrackerId':99,'status':408})]
        txt=[event(t,'http request onTimeout trackerId=99'),event(t+1,'http request onTimeout trackerId=99')]
        self.assertEqual(self.run_summary(s,txt)['timeout_join']['joined_408_by_host_tracker_time'],1)

    def test_all_raw_fields_and_unknown_log_types_omitted(self):
        t=self.base
        s=[event(t,{'logType':'SecretFunnyType Bearer MY_PRIVATE_KEY','messagePreview':'private-message-body','token':'secret-user-token'})]
        txt=[event(t,'some private source line')]
        out=self.run_summary(s,txt)
        text=json.dumps(out)
        for secret in ['SecretFunnyType','MY_PRIVATE_KEY','private-message-body','secret-user-token','some private source line']:
            self.assertNotIn(secret,text)
        self.assertEqual(out['types']['UNKNOWN_OR_OTHER'],1)

    def test_missing_essential_fields_is_tolerated(self):
        t=self.base
        out=self.run_summary([{'message': {'logType':'BeforeSendLog'}},{'message':'unexpected'}], [{'level':'WARN','message':None}])
        self.assertEqual(out['data_quality']['send_missing_correlation_key'],1)
        self.assertEqual(out['data_quality']['non_object_structured_message'],1)
        self.assertFalse(out['shared_time_window_exists'])

    def test_malformed_json_no_input_echo(self):
        self.s.write_text('{"BAD_SECRET": UNPARSABLE\n',encoding='utf-8')
        self.t.write_text('{}\n',encoding='utf-8')
        with self.assertRaises(ValueError) as ctx:summarize(self.s,self.t)
        self.assertNotIn('BAD_SECRET',str(ctx.exception))
        self.assertIn('line 1',str(ctx.exception))

    def test_temporal_overlap_flag(self):
        t=self.base
        self.assertFalse(self.run_summary([event(t,{})],[event(t+200,{})])['shared_time_window_exists'])
        self.assertTrue(self.run_summary([event(t,{}),event(t+300,{})],[event(t+200,{})])['shared_time_window_exists'])

if __name__=='__main__':unittest.main(verbosity=2)