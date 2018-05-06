n = gets.to_i
star_table = gets.split.map(&:to_i)
t = gets.to_i
lines = ARGF.map do |line|
  name, question = line.split
  [name, question.ord - "A".ord]
end


ranking_table = Hash.new(0)
score_table = Hash.new{|ht, ky| ht[ky] = Array.new(star_table.size, 0)}
last_table = Hash.new(Float::INFINITY)

lines.each.with_index(0) do |(name, question), idx|
  star = star_table[question]
  ranking = (ranking_table[question] += 1)
  
  score_table[name][question] = (star * 50 + 50 * star / (0.8 + 0.2 * ranking)).to_i  
  last_table[name] = idx
end

names = score_table.keys.sort do |name1, name2| 
  diff = score_table[name2].reduce(:+) - score_table[name1].reduce(:+)
  diff.zero? ? last_table[name1] - last_table[name2] : diff 
end

results = []
names.each.with_index(1) do |name, idx|
  scores = score_table[name].map(&:to_s).join("\s")
  sum = score_table[name].reduce(:+)
  results << "#{idx} #{name} #{scores} #{sum}"
end

puts results.join("\n")
