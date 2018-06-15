#/bin/bash

fold -s1 | awk '{
  mod3 = (mod3 * 4 + $0) % 3
  mod5 = (mod5 * 4 + $0) % 5
  n = n $0
} END {
  print (mod3 == 0 && mod5 == 0) ? "FizzBuzz" :
        (mod3 == 0             ) ? "Fizz"     :
        (             mod5 == 0) ? "Buzz"     : n;
}'