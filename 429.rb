def f(cups, logs)
  logs.each{|x, y| cups[x - 1], cups[y - 1] = cups[y - 1], cups[x - 1]}
end

n, k, x = gets.split.map(&:to_i)
ls = (1..k).each_with_object([]){|_, arr| arr << gets.split.map(&:to_i)}
before = ls[0, x - 1]
after = ls[x..-1].reverse

start = (1..n).to_a; f(start, before)
answer = gets.split.map(&:to_i); f(answer, after)

puts (0...n).each_with_object([]){|i, arr| arr << i + 1 if start[i] != answer[i]}.join("\s")
