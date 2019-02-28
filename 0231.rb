n = gets.to_i
glist, dlist = n.times.map{ gets.split.map(&:to_i) }.transpose

k = n.times.max_by{|i| glist[i] - 30000 * dlist[i]}
if 30000 * 100 <= (glist[k] - 30000 * dlist[k]) * 6
  puts "YES"
  6.times{ puts k + 1}
else
  puts "NO"
end