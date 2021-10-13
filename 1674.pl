use strict;
use warnings;
use List::Util qw(first);

my $n = <>;
my @a = split / /, <>;

for (my $x = 1; ; $x *= 2) {
    unless (first {$_ & $x} @a) {
        print "$x\n";
        exit;
    }
}