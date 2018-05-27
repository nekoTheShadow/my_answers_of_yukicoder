n = gets.to_i
scores = gets.split("\s").map(&:to_i)
answerers = gets.split("\s").map(&:to_i)

hash = Hash.new(0)
(0...n).each{|i| hash[answerers[i]] += scores[i]}

winner = (0..100).inject(0){|t, i| hash[t] < hash[i] ? i : t}
puts winner.zero? ? "YES" : "NO"
