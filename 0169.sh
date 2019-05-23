#!/bin/bash

read k
read s
echo "$s / ((100 - $k) / 100)" | bc -l | sed 's/\..*//'