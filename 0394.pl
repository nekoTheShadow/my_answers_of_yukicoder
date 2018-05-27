my @points = get().split(" ").map({Int($_)});
my $sum = @points.sum - @points.max - @points.min;
my $avg = $sum / 4;
printf("%.2f", $avg);
