#!/bin/bash

read s
echo ${s} | fold -s1 | awk 'BEGIN{
  x = 0
  y = 0
  c = 0
} {
  c += 1
  if ($0 == "N") x += 1
  if ($0 == "S") x -= 1
  if ($0 == "E") y += 1
  if ($0 == "W") y -= 1
} END {
  print(sqrt(x * x + y * y))
}'