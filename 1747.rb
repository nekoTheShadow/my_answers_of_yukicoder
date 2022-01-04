require "prime"
@s = gets.chomp
def f(x) = x==@s.size-1 ? [@s[x]] : f(x+1).flat_map{["#{@s[x]}+#{_1}", "#{@s[x]}#{_1}"]}
puts f(0).count{eval(_1).prime?}