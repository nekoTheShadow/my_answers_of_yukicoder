n = gets.to_i
numbers = gets.split("\s").map(&:to_i)

if n == 1
    p numbers[0]
    exit
end

dp = [numbers[0], [numbers[0], numbers[1]].max]
(2...n).each{|k| dp[k] = [dp[k - 2] + numbers[k], dp[k - 1]].max}
p dp[n - 1]
