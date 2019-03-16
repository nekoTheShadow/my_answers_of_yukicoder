n = gets.to_i
a = gets.split.map(&:to_i)
b = a.reduce{|x, y| x.gcd(y)}
puts a.map{|x| x / b}.join(":")