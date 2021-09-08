use strict;
use warnings;
use feature qw/state/;
use Time::Piece;

sub output {
    print "@_\n";
}

sub input {
    state @que;
    if (@que == 0) {
        chomp(my $line = <>);
        push @que, split / /, $line;
    }
    return shift @que;
}

my $a = input;
my $t = Time::Piece->strptime("10:00", "%H:%M") + ($a / 100 * 60 * 60);
output $t->strftime("%H:%M");