n, m = gets.split.map(&:to_i)
has_love = n.times.any?{ gets.chomp.include?("LOVE") }
puts has_love ? "YES" : "NO"