#!/bin/bash

read -s h w

awk -v FS='' '{
	lines[NR] = $0
	if (x != 0) next;
	
	cnt = 0
	for(i = 1; i <= NF; i++) cnt += ($i == "*" ? 1 : 0);
	
	if (cnt == 2) x = (NR != 1) ? NR - 1 : NR + 1;
	if (cnt == 1) x = NR;
} END {
    sub(/-/, "*", lines[x])
    len = 0; for(i in lines) len++;
    for (i = 1; i <= len; i++) print lines[i];
}' 
