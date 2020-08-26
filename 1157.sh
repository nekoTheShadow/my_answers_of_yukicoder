awk '{n=$0; for(i=1;i<=n;i++) a[int(n/i)]++; print length(a)}'
