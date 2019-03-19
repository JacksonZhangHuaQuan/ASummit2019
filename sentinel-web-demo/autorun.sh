#!/bin/bash

for i in {1..1000}
do
   url="localhost:8080/hello?msg=ASummit2019_$i"
   echo "curl $url"
   curl $url
   echo ""
   sleep 0.1
done