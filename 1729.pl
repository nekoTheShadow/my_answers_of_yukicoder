use strict;
use warnings;
use bigint;
use Data::Dumper;
use List::Util qw/max/;

chomp(my $N = <>);

my $dec = 0;
my $base = 1;
foreach (reverse split //, $N) {
    $dec += $base * (ord($_) - ord('A') + 10);
    $base *= 16;
}

my %h1;
while ($dec > 0) {
    $h1{$dec%8}++;
    $dec /= 8;
}

my %h2;
push @{$h2{$h1{$_}}}, $_ foreach (keys %h1);

print join(" ", sort @{$h2{max keys %h2}}), "\n";