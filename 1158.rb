a, b, n = gets.split.map(&:to_i)
puts [*a..b].repeated_permutation(n).reduce(1){|acc, v| acc * v.reduce(:gcd) % (10 ** 9 + 7)}
