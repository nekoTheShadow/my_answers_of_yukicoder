@memo = {0 => 4, 1 => 3}
def a(k)
    @memo[k] ||= (a(k - 1) * 19 - a(k - 2) * 12).quo(4)
end

k = gets.to_i
printf("%.15f", a(k))
