#!/usr/bin/env python3
"""Reproduce v0.18.1 metadata-only selector and assess a *proposed* topic-index fix.

This is an isolated, read-only selector approximation, NOT a test of live n8n.
Only id/path/type/domain/trust are used; no sensitive data, no network.
Usage: python3 retrieval_contract_regression.py --catalog async-knowledge-catalog.yaml
"""
import argparse
import json
import re
from pathlib import Path

STOP = set('برای این یک که شود شده شوند نمیشود نمیشوند میخوام داریم دارد درباره در از به با روی چی چرا چطور کن بکن بررسی تحلیل تحلیلکن نیازمندی نیازمندیها وضعیت فعلی موجود سیستم فایل کلاس متد کد سورس اجرا فعال فعالسازی آنها خود اصلی نقش مسئولیت نمی می سازی the and for with from this that have want into between current existing implementation system file class method code source analyze analysis requirement requirements status enable enabled activation src java user'.split())

TESTS = [
  ('BeforeSend و AfterSend آیا ACK نهایی را اثبات می‌کند؟',
   ['async-observability-source-semantics','async-message-delivery-flow']),
  ('در لاگ‌های قدیمی، همه Status 408ها قطعاً Listener Timeout بوده‌اند؟',
   ['async-observability-historical-2026-08-18','async-observability-correlation-contract']),
  ('برای Invalid Queue Name چه مسیر بررسی و محدودیت نسخه سورس داریم؟',
   ['async-observability-investigation-playbooks','async-observability-historical-2026-08-18']),
  ('۱۵ معیار QC Agent کجا ثبت شده‌اند؟',
   ['async-observability-agent-qc-cases'])
]

# Proposed topic index; not an approved or deployed workflow patch.
TOPICS = [
  {'id':'message-ack','anchors':{'beforesend','aftersend','ack','delivery','retry'},'min':2,'docs':TESTS[0][1]},
  {'id':'http-timeout','anchors':{'408','listener','timeout','http'},'min':2,'docs':TESTS[1][1]},
  {'id':'broker-invalid','anchors':{'invalid','queue','name','broker'},'min':2,'docs':TESTS[2][1]},
  {'id':'agent-qc','anchors':{'qc','agent','سناریوهای','تست'},'min':2,'docs':TESTS[3][1]}
]

def norm(s):
    return str(s or '').lower().replace('ي','ی').replace('ك','ک').replace('\u200c','').strip('._- ')

def terms(question):
    s=question[:20000].replace('ي','ی').replace('ك','ک').replace('\u200c','')
    words=[norm(x) for x in re.split(r'[^A-Za-z0-9_\-\u0600-\u06ff.]+',s) if x]
    out=[]
    for x in words:
        if len(x)>=3 and x not in STOP and x not in out:
            out.append(x)
    return out[:24]

def topic_token(token):
    # Approximate morphology normalization for numeric suffixes in Persian (e.g. 408ها).
    return re.sub(r'^(\d+)(ها|های)$',r'\1',norm(token))

def parse_catalog(text):
    docs=[];cur=None
    for raw in text.splitlines():
        line=raw.strip()
        if line.startswith('- id:'):
            if cur:docs.append(cur)
            cur={'id':line[5:].strip()}
        elif cur:
            for field in ('path','type','domain','trust'):
                if line.startswith(field+':'):
                    cur[field]=line[len(field)+1:].strip().strip('"\'')
    if cur:docs.append(cur)
    return docs

def baseline(documents,query):
    ts=terms(query)
    scored=[]
    for d in documents:
        corpus=norm(' '.join(d.get(k,'') for k in ('id','path','type','domain','trust')))
        score=sum(4 if len(t)>8 else 2 for t in ts if norm(t) in corpus)
        scored.append((score,d['id']))
    scored.sort(key=lambda x:-x[0])
    positives=[(s,id) for s,id in scored if s>0][:8]
    return {'ids':[id for _,id in (positives or scored[:4])], 'fallback':not bool(positives),'terms':ts}

def proposed(documents,query):
    available={d['id'] for d in documents}
    ts=terms(query)
    whole={topic_token(x) for x in ts}
    boosted={};matched=[]
    for topic in TOPICS:
        hits=whole & topic['anchors']
        if len(hits)>=topic['min']:
            matched.append(topic['id'])
            for id in topic['docs']:
                if id in available:boosted[id]=boosted.get(id,0)+12
    scored=[]
    for d in documents:
        doc_tokens={x for x in re.split(r'[^a-z0-9_\u0600-\u06ff]+',norm(' '.join(d.get(k,'') for k in ('id','path','type','domain')))) if x}
        # No substring matching; 'ack' must not match backpressure/backlog.
        lexical=2*len(whole & doc_tokens)
        score=lexical+boosted.get(d['id'],0)
        scored.append((score,d['id']))
    scored.sort(key=lambda x:-x[0]);positives=[(s,id) for s,id in scored if s>0][:8]
    return {'ids':[id for _,id in (positives or scored[:4])], 'fallback':not bool(positives),'topics':matched}

def main():
    p=argparse.ArgumentParser();p.add_argument('--catalog',required=True);p.add_argument('--report');arg=p.parse_args()
    doc=parse_catalog(Path(arg.catalog).read_text(encoding='utf-8'))
    assert len(doc)==25 and len({d['id'] for d in doc})==25,'expected verified 25-doc snapshot'
    rows=[];passcount=0
    for question,expected in TESTS:
        b=baseline(doc,question);n=proposed(doc,question)
        baseline_all=all(x in b['ids'] for x in expected)
        proposed_all=all(x in n['ids'] for x in expected)
        assert proposed_all, (question,n)
        passcount+=1
        rows.append({'case':len(rows)+1,'question':question,'expected':expected,'baseline_selected':b['ids'],'baseline_fallback':b['fallback'],'baseline_all_expected':baseline_all,'proposed_selected':n['ids'],'proposed_topics':n['topics'],'proposed_all_expected':proposed_all})
    # Negative regression: do not confuse ACK with substring in backlog/backpressure.
    negative=proposed(doc,'ack')
    assert 'async-human-knowledge-backlog' not in negative['ids']
    assert 'async-observability-persistence-backpressure-adr' not in negative['ids']
    # Out-of-vocabulary should not be asserted as relevant evidence.
    unknown=proposed(doc,'zzzxnotrealterm')
    assert unknown['fallback']
    summary={'snapshot_document_count':len(doc),'workflow':'v0.18.1_export_simulated_not_live','baseline_cases_containing_all_expected':sum(x['baseline_all_expected'] for x in rows),'proposed_cases_containing_all_expected':passcount,'negative_tests_passed':2,'cases':rows,'notes':['This is a Python port of the export\'s metadata-only selection, not execution of n8n JS.','Proposed topic-index strategy requires review, workflow version identification, integration regression and actual n8n smoke tests.','Fallback documents are not evidence by themselves.']}
    if arg.report:Path(arg.report).write_text(json.dumps(summary,ensure_ascii=False,indent=2),encoding='utf-8')
    print(json.dumps({k:v for k,v in summary.items() if k!='cases'},ensure_ascii=False,indent=2))

if __name__=='__main__':main()