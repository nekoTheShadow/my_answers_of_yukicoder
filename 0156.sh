#!/bin/bash

read n m
read c
echo ${c} | tr ' ' '\n' | sort -n | awk -v m="${m}" '
BEGIN {
  c = 0
} 
(m > 0) {
  if ($0 <= m) c += 1
  m -= $0
}
END {
  print(c)
}'