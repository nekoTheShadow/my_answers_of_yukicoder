n, x = gets.split.map(&:to_i)
digits = gets.split.map(&:to_i)

table = Hash.new(0)
digits.each{|digit| table[digit] += 1}

cnt = 0
table.keys.each do |digit|
  cnt += table[digit] * table[x - digit]
end

puts cnt