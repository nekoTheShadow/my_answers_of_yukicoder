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

my $N = input;
foreach my $a1 (1..10) {
    foreach my $a2 (1..10) {
        if ($a1+$a2 == $N) {
            output $a1, $a2;
            exit;
        } 
    }
}