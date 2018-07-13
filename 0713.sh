#!/bin/bash
read n; seq $n | factor | awk 'BEGIN{t=0}NF==2{t+=$2}END{print t}'
