#!/bin/bash

echo $(cat /dev/stdin | tail -n 1 | awk '{
	for (i = 1; i <= NF; i++) print($i)
}' | sort -g) | awk '{
	pivot = $2 - $1
	for (i = 1; i < NF; i++) {
		diff = $(i + 1) - $i
		if (diff == 0 || diff != pivot) exit 9;
	}
}'

[ $? -eq 0 ] && echo "YES" || echo "NO" 
