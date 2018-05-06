n = gets.to_i
words = $<.map{|line| line.chomp + "}"}

alphabets = []

words.inject(0){|sum, word| sum + word.size - 1}.times do
    x = (0...n).min_by{|i| words[i]}
    alphabets << words[x].slice!(0)
end

puts alphabets.join
