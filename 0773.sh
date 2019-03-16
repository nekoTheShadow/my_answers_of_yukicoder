#!/bin/bash

read a b
cnt=3
for d in 23 24 25; do
  (( a <= d && d <= b)) && cnt=$(( cnt - 1 ))
done
echo ${cnt}