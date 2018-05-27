#!/bin/bash

read n
read legs

sum=$(echo $legs | awk -v n="$n" '{
	for (i = 1; i <= NF; i++) sum += $i;
	print(sum / (n - 1))
}')

echo $legs | awk -v sum="$sum" '{
	cnt[2] = cnt[4] = 0
	for (i = 1; i <= NF; i++) cnt[sum - $i] += 1;
	print(cnt[2] " " cnt[4])
}'
