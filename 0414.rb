def f(m)
    return "2 #{m / 2}" if m.even?
    (3..Math.sqrt(m).ceil).step(2){|i| return "#{i} #{m / i}" if m % i == 0}
    "1 #{m}"
end

# == main ==
m = gets.to_i
puts f(m)
