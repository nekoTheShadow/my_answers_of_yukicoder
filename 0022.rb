n, k = STDIN.gets.split.map(&:to_i)
tokens = STDIN.gets.chomp.chars

stack = []
tokens.each.with_index(1) do |token, i|
  stack << i if token == "("
  
  if token == ")"
    j = stack.pop
    if [i, j].include?(k)
      puts i == k ? j : i
      break
    end
  end
end
