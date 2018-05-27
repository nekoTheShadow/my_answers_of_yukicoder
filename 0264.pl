sub judge($a, $b){
    my $c = ($a - $b + 3) % 3;
    $c == 0 ?? "Drew" !! $c == 2 ?? "Won" !! "Lost";
}

my ($n, $k) = get().split(" ");
say judge($n, $k);
