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

my $red = 0;
my $blue = 0;
foreach(0..2) {
    my $s = input;
    $red++ if ($s eq "RED");
    $blue++ if ($s eq "BLUE");
}
say($blue < $red ? "RED" : "BLUE");