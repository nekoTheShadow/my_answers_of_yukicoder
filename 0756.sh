#!/bin/bash
read d
seq 10000 | paste -sd'\0' | fold -s1 | awk "NR==${d}"