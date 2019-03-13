n1 = gets.to_i
a = gets.split.map(&:to_r)
n2 = gets.to_i
b = gets.split.map(&:to_r)

numer = a[0]
(1...n1).each{|i| numer /= a[i]}

denom = b[n2 - 1]
(0..(n2 - 2)).reverse_each{|i| denom = b[i] / denom}

ans = numer / denom
puts "#{ans.numerator} #{ans.denominator}"
