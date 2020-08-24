n = gets.to_i
a = Array.new(n){Array.new(n)}

[*0...n].product([*0...n]) do |i, j|
  a[i][j] = (2*i-j+n)%n
end

a.each do |row|
  line = row.map{|v| v + 1}.join(" ")
  puts line
end