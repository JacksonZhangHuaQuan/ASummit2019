#!/bin/bash

for i in {1..10000}
do
   url="localhost:8080/hello?msg=ASummit2019_$i&slow=true"
   echo "curl $url"
   curl $url
   echo ""
   sleep 0.1
done