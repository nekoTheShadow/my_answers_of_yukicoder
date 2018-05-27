my ($l, $m, $n) = map {Int($_)}, (get() for (1..3));

$m += $n div 25;
$n = $n % 25;

$l += $m div 4;
$m = $m % 4;

my $t = $l div 10;
$l = $l % 10;

say $l + $m + $n;
