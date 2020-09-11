s = gets.chomp
t = "abcdefghijklmnopqrstuvwxyz"
s.size.times do |i|
  puts "#{t[i]}to#{s[i]}" if s[i] != t[i]
end