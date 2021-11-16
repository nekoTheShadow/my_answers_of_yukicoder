use strict;
use warnings;

sub factor {
    my $n = shift;
    my %h;
    for (my $m = 2; $m*$m <= $n; $m++) {
        while ($n % $m == 0) {
            $h{$m}++;
            $n /= $m;
        }
    }

    $h{$n}++ if ($n > 1);
    return \%h;
}

sub main {
    my ($x, $a, $y, $b) = split / /, <>;
    my %h1 = %{factor($x)};
    my %h2 = %{factor($y)};

    foreach my $k (keys %h2) {
        return "No" unless (exists $h1{$k} and $h1{$k}*$a >= $h2{$k}*$b);
    }
    return "Yes";
}

print main, "\n";

