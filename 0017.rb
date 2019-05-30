n = gets.to_i
s = n.times.map{ gets.to_i }
m = gets.to_i
a, b, c = m.times.map{ gets.split.map(&:to_i) }.transpose

wf = Array.new(n){ Array.new(n, Float::INFINITY) }
n.times{|i| wf[i][i] = 0 }
m.times{|i| wf[a[i]][b[i]] = wf[b[i]][a[i]] = c[i]}
n.times do |k|
  n.times do |i|
    n.times do |j|
      wf[i][j] = [wf[i][j], wf[i][k] + wf[k][j]].min
    end
  end 
end

ans = [*1..(n - 2)].permutation(2)
                   .map{|x, y| (wf[0][x] + wf[x][y] + wf[y][n - 1]) + (s[x] + s[y])}
                   .min
puts ans