#!/bin/bash

awk '
  NR==1 {
    n=$1
    m=$2
    for(i=1;i<=m;i++) a[i]=0
  }
  NR==2 {
    for(i=1;i<=NF;i++) a[$i]++
  }
  END {
    for(i=1;i<=m;i++) print i, a[i]
  }
'