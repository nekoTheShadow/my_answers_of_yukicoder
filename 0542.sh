#/bin/bash
read a b
seq 0 ${a} | awk -v b=${b} '{for(i=0; i<=b; i++) print $1 + 5 * i}' | sort -n | uniq | awk 'NR!=1'
