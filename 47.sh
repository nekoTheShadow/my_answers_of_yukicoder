#!/bin/bash


awk '{
	cookie = 1
	cnt = 0
	
	while (cookie < $0) {
		cookie = cookie * 2
		cnt += 1
	}
	
	print cnt
}'
