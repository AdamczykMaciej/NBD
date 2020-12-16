import requests
import json

def print_request(request,ith):
        print(ith,'.)')
        print("Headers:\n",json.dumps(dict(request.headers), indent=1))
        if( request.text):
                print("Text:\n",request.text)

riak_url = "http://localhost:8098/buckets/s15170/keys/person"
headers={'content-type':'application/json', 'cache-control':'no-cache'}
person={'name':'Jan Kowalski','nationality':'Poland','date-of-birth':'1992-Nov-09' }
modified_person={'name':'Jan Kowalski','nationality':'Spain','date-of-birth':'1992-Nov-09' }

my_requests = []
my_requests.append(requests.post(riak_url,data=person, headers=headers))
my_requests.append(requests.get(riak_url))
my_requests.append(requests.put(riak_url,data=modified_person, headers=headers))
my_requests.append(requests.get(riak_url))
my_requests.append(requests.delete(riak_url))
my_requests.append(requests.get(riak_url))

for (r,i) in zip(my_requests, range(1,len(my_requests)+1)):
        print_request(r,i)
