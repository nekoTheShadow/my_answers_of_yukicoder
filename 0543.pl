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


# PとPの対偶、Pの逆とPの裏ではそれぞれ真偽が一致する
my $a = input; # P
my $b = input; # Pの逆
my $c = $b; # Pの裏
my $d = $a; # Pの待遇
output $c, $d;