#!/bin/bash

read k
awk -v k=${k} 'BEGIN {
  dice1[1] = 4
  dice1[2] = 6
  dice1[3] = 8
  dice1[4] = 9
  dice1[5] = 10
  dice1[6] = 12

  dice2[1] = 2
  dice2[2] = 3
  dice2[3] = 5
  dice2[4] = 7
  dice2[5] = 11
  dice2[6] = 13

  x = 0
  y = 0
  for (i = 1; i <= length(dice1); i++) {
    for (j = 1; j <= length(dice2); j++) {
      x += 1
      if (dice1[i] * dice2[j] == k) y += 1
    }
  }
  printf("%.20f\n", y / x)
}'