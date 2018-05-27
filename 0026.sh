#!/bin/bash

read n
read m

awk -v n="$n" '
	BEGIN{
		for (i = 1; i <= 3; i++) cups[i] = 0;
		cups[n] = 1
	}
	{
		temp = cups[$1]
		cups[$1] = cups[$2]
		cups[$2] = temp
	}
	END{
		for (i = 1; i <= 3; i++) {
			if (cups[i] == 1) print i;
		}
	}'
