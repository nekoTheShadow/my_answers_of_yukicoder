def f(n, z)
  [*1..z].product([*1...z]) do |x, y|
    return "Yes" if x**n + y**n == z**n
  end
  return "No"
end

n, z = gets.split.map(&:to_i)
puts f(n, z)