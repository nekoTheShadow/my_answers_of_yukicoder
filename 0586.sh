#!/bin/bash
read p1; read p2; read n; sort | uniq -c | awk -v p="$((p1+p2))" '{sum+=$1-1} END{print sum * p}'
