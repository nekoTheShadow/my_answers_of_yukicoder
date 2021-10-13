use strict;
use warnings;
use List::Util qw(max);

my $n = <>;
my @a = split / /, <>;
my @b = sort {$a[$a-1] <=> $a[$b-1]} 1..$n;

my $ans = 0;
my $now = 0;
for (my $i = 0; $i < $n-1; $i++) {
    my $x = $b[$i];
    my $y = $b[$i+1];
    
    $now += $x;
    $ans = max($ans, $now-$y);
}
print "$ans\n";
