def f(n)
  a = 0
  (1..).each do |i|
    b = a + 1.0 / i**n
    return b if a == b
    a = b
  end
end

n = gets.to_i
p f(n)
