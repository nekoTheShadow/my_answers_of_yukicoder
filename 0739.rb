def solve(str)
  len = str.size
  return false if len.odd?
  
  mid = len / 2
  str[0...mid] == str[mid..-1]
end

str = gets.chomp
puts solve(str) ? 'YES' : 'NO'