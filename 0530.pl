use strict;
use warnings;
use feature qw/say state/;

sub input() {
    state @que;
    if (@que == 0) {
        chomp(my $line = <>);
        push @que, split / /, $line;
    }
    return shift @que;
}

my $y = input;
say 2017-$y;