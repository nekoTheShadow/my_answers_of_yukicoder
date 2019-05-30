t = gets.to_i
n = gets.to_i
c = gets.split.map(&:to_i) # 並び時間
v = gets.split.map(&:to_i) # 満足度

n.times do |i|
  x = v[i] / 2
  while x > 0
    c << c[i]
    v << x
    x /= 2
  end
end

# dp[チェックしたアトラクションの数][並んだ時間] = 満足度
m = c.size
dp = Array.new(m + 1){ Array.new(t + 1, -Float::INFINITY) }
dp[0][0] = 0

m.times do |i|
  (t + 1).times do |j|
    dp[i + 1][j] = [dp[i + 1][j], dp[i][j]].max
    dp[i + 1][j + c[i]] = [dp[i + 1][j + c[i]], dp[i][j] + v[i]].max if j + c[i] <= t
  end
end

puts dp[-1].max