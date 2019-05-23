#!/bin/bash

read c1
read c2
s="${c1}${c2}"

if [[ ${s} =~ ^x*$ ]]; then
  echo 0
  exit 0
fi

echo ${s}                | 
sed -E 's/x+/ /g'        | 
tr ' ' '\n'              | 
awk '{print length($0)}' |
sort -n                  |
tail -n 1