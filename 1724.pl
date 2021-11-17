use strict;
use warnings;

my ($N, $K) = split / /, <>;
my @A = split / /, <>;
my @B = split / /, <>;

my @c = reverse sort {$A[$a]-$B[$a] <=> $A[$b]-$B[$b]} 0..$N-1;
my %is_a = map {$_, 1} splice @c, 0, $K;
print map({$is_a{$_} ? "A" : "B"} 0..$N-1), "\n";
