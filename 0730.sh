fold -s1 | sort | uniq -c | awk '$1!=1{c++} END{print c==0?"YES":"NO"}' 