#!/bin/bash

read k n f
read vals

echo $vals | awk -v k="$k" -v n="$n" '{
	sum = 0
	for(i = 1; i <= NF; i++) sum += $i;
	
	ans = k * n - sum
	print ans < 0 ? -1 : ans
}'
