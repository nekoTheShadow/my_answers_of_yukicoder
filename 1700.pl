use utf8;
use strict;
use warnings;

sub bisect {
    my $n = shift;

    my $ok = 0;
    my $ng = $n+1;
    while (abs($ok-$ng) > 1) {
        my $mi = int(($ok + $ng) / 2);
        if ($mi*$mi <= $n) {
            $ok = $mi;
        } else {
            $ng = $mi;
        }
    }

    $ok;
}

my $t = <>;
while ($t--) {
    my $n = <>;
    print bisect($n), "\n";
}