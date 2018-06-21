#!/bin/bash
read n k; seq 2 ${n} | factor | awk -v k="${k}" '{split("", a, ""); for(i=2;i<=NF;i++) a[$i]=1; if (k<=length(a)) print 1}' | wc -l
