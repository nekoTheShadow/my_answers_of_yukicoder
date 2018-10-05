N, M, P, Q = gets.chomp.split(' ').map(&:to_i)

div, mod = N.divmod(M * 12 + M * Q)
ans = div * 12

leafs = Array.new(12, M)
(P...P+Q).each{|month| leafs[month - 1] += M}
leafs.each do |leaf|
  break if mod <= 0
  ans += 1
  mod -= leaf
end

puts ans


