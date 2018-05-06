def f(base, token)
  i = cnt = 0
  while i = base.index(token, i) 
    i += 1
    cnt += 1
  end
  cnt
end

base = gets.chomp
m = gets.to_i
tokens = $<.map(&:chomp)

p tokens.reduce(0){|sum, token| sum + f(base, token)}
