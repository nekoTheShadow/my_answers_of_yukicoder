h, a, d = gets.split.map(&:to_i)

dp = Array.new(h + 1, Float::INFINITY)
dp[0] = 0
h.times do |i|
  j = [i + a, h].min
  dp[j] = [dp[j], dp[i] + 1].min

  k = [i + d, h].min
  dp[k] = [dp[k], dp[i] + 1.5].min
end

p dp[h]
