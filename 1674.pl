use strict;
use warnings;
use feature qw/state/;

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

sub main {
    my $n = input;
    my $q = input;

    my @d = (0) x $n;
    my $c = 0;
    foreach (1..$q) {
        my $l = input - 1;
        my $r = input - 1;
        foreach my $i ($l..$r) {
            $d[$i] = abs($d[$i]-1);
            $d[$i]==0 ? $c-- : $c++;
        }
        output $c;
    }
}

main;