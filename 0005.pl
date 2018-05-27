my $l = Int(get());
my $n = Int(get());
my @w = get().split(" ").map({Int($_)}).sort;

my $cnt = 0;
for @w {
    $l -= $_;
    last if $l < 0;
    $cnt++;
}

say $cnt;
