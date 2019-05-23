#!/bin/bash

read s
echo ${s} | fold -s1 | sort | uniq -c | awk '{
  d[$2] = ($2 == "e") ? int($1 / 2) : $1
} END {
  OFS = "\n"
  print d["t"], d["r"], d["e"]
}' | sort -n | head -n1