use strict;
use warnings;
use feature qw/state/;

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

my $t = input;
my @x = (0);
for (my $i = 0; $i < $t; $i++) {
    push @x, input;
}
for (my $i = 0; $i < $t; $i++) {
    if (abs($x[$i] - $x[$i+1]) != 1) {
        output "F";
        exit;
    }
}
output "T";