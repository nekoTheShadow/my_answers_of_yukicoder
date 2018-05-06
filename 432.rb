def f(line)
    arr = line.split("").map(&:to_i)
    arr = (0..(arr.size - 2)).each_with_object([]){|i, temp| temp << (arr[i] + arr[i + 1]).divmod(10).reduce(&:+)} while arr.size > 1
    arr.first
end

n = STDIN.gets
STDIN.map(&:chomp).each{|line| puts f(line)}
