n = gets.strip
puts  [*0...n.size].product([*0...n.size]).each_with_object([]){|(i, j), arr|
    t = n.dup
    t[i], t[j] = t[j], t[i]
    arr << t.to_i
}.max

