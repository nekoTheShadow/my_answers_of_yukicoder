n, m = gets.chomp.split.map(&:to_i)
w = gets.chomp.split.map(&:to_i)

tot = w.sum
if tot.zero? 
  puts w.join(' ')
else
  puts w.map{|v| (m.quo(tot)*v).to_i}.join(' ')
end