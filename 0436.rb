s = STDIN.gets.chomp

c = s.count("c")
w = s.count("w")

puts [c - 1, w].min

