my ($a, $b) = lines;
say $a.comb.sort eq $b.comb.sort ?? "YES" !! "NO";
