#/bin/bash

read n
tr ' ' '\n' | awk -v n=${n} '
($0 == "nyanpass"){
  d[(NR - 1) % n] += 1
}
END {
  for (k in d) {
    if (d[k] == n - 1) {
      c += 1
      v = k + 1
    }
  }
  
  print (c == 1) ? v : -1
}'
