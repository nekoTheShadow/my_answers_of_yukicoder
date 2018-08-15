def anzan?(x)
  x = x.abs
  
  cnt = 0
  while x > 0 && x % 10 == 0
    cnt += 1
    x /= 10
  end

  cnt >= 2 && 1 <= x && x <= 9
end

a, b = gets.split.map(&:to_i)
if anzan?(a) && anzan?(b)
  puts (a * b) / 10
else
  ans = a * b
  puts -99999999 <= ans && ans <= 99999999 ? ans : "E"
end
