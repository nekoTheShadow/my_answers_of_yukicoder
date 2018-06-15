def solve(n)
  # 与えられた自然数nが三角数である必要条件はt=(sqrt(8*n+1)-1)/2が整数であること。
  x = 8 * n + 1
  root = Math.sqrt(x).to_i
  return nil if root ** 2 != x

  y = root - 1
  y % 2 == 0 ? y / 2 : nil
end

n = gets.to_i
if answer = solve(n)
  puts "YES", answer
else
  puts "NO"
end


