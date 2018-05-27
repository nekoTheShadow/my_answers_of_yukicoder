sub has3($x){
    my $t = $x;
    while $t > 0 {
        return True if $t % 10 == 3;
        $t = $t div 10;
    }
    False;
}

sub is_multiple_of_3($x){
    $x % 3 == 0;
}


my ($a, $b) = get().split(" ").map({Int($_)});
for $a..$b {
    say $_ if is_multiple_of_3($_) || has3($_);
}
