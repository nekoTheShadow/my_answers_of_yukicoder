use strict;
use warnings;
use feature qw/state bitwise/;

sub output {
    my $line = join " ", @_;
    print "$line\n";
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
my $b = input;
output $a ^ $b;