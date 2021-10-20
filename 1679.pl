use strict;
use warnings;
use utf8;

use List::Util qw/reduce/;

sub gets {
    chomp(my $s = <>);
    return $s;
}

my $n = gets;
my %p;
my %q;
for (my $i = 0; $i < $n; $i++) {
    my ($a, $b, $t) = split / /, gets;
    $a==0 ? $p{$b-$t}++ : $q{$b-$t}++; 
}

my $ans = reduce {$q{$b} ? $a+$p{$b}*$q{$b} : $a} 0, keys(%p);
print $ans, "\n";
