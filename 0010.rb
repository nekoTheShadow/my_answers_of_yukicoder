n = gets.to_i
t = gets.to_i
a = gets.split.map(&:to_i)

dp = Array.new(n + 1){ Array.new(t + 1, "!") }
dp[1][a[0]] = ""
(1...n).each do |x|
  (0..t).each do |y|
    next if dp[x][y] == "!"
    dp[x + 1][y + a[x]] = [dp[x + 1][y + a[x]], dp[x][y] + "+"].max if y + a[x] <= t
    dp[x + 1][y * a[x]] = [dp[x + 1][y * a[x]], dp[x][y] + "*"].max if y * a[x] <= t
  end
end

puts dp[n][t]

