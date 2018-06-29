#!/bin/bash
fold -s1 | sort | uniq -c | sort -nr | awk '{a[$1]+=1} END{print a[1]==1 && a[2]==6 ? $2 : "Impossible"}'
