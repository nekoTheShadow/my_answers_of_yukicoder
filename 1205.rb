N, M = gets.split.map(&:to_i)
T, P = M.times.map{ gets.split.map(&:to_i) }.transpose

T.unshift 0
P.unshift 0

if M.times.all?{|i| (P[i]-P[i+1]).abs <= (T[i]-T[i+1]).abs}
  puts "Yes"
else
  puts "No"
end