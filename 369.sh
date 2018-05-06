#!/bin/bash

read n
read numbers
read yuki

echo $numbers | awk -v yuki="$yuki" '{
	sum = 0
	for(i = 1; i <= NF; i++) sum += $i;
	print sum - yuki
}'
