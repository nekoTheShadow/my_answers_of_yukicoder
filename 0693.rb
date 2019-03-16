n = gets.to_i
a = gets.split.map(&:to_i).sort
puts a.zip([*1..n]).reduce(0){|sum, (x, y)| sum + (x - y).abs}