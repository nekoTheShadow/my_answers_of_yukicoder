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

my $s = input;
output($s =~ /^[45]/ ? "Yes" : "No");