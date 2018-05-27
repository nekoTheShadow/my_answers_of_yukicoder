my $n = Int(get());
my @nums = get().split(" ").map({Int($_)}).sort;

if $n % 2 == 0 {
    say (@nums[$n div 2 - 1] + @nums[$n div 2]) / 2;
} else {
    say @nums[$n div 2];
}
