use strict;
use warnings;
use List::Util qw(sum);

sub gets {
    chomp(my $line = <>);
    $line;
}

my $n = gets;
my @a = split / /, gets;

my %b = map {$_, 1} @a;
printf "%d\n", sum(grep {!exists($b{$_-1})} @a);