use strict;
use warnings;

sub gets {
    chomp(my $line = <>);
    $line;
}

my ($n, $m) = split / /, gets;
my @a = split / /, gets;

my %h = map {$_, 1} @a;
my $max = keys(%h);
if ($max==1 && $n==$m) {
    print "$max 1\n";
} else {
    print "$max 0\n";
}

