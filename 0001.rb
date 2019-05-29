n = gets.to_i - 1
c = gets.to_i 
v = gets.to_i
s = gets.split.map{|s| s.to_i - 1 }
t = gets.split.map{|s| s.to_i - 1 }
y = gets.split.map(&:to_i) # コスト
m = gets.split.map(&:to_i) # 時間


# dp[現在地点][コスト] = 時間 
dp = Array.new(n + 1){ Array.new(c + 1, Float::INFINITY) }
dp[0][0] = 0

[*0..(n + 1)].product([*0..(c + 1)]) do |current, amount|
  v.times do |i|
    next if current != s[i]
    dp[t[i]][amount + y[i]] = [dp[t[i]][amount + y[i]], dp[current][amount] + m[i]].min if amount + y[i] <= c
  end
end

ans = dp[n].min
puts (ans == Float::INFINITY) ? -1 : ans
