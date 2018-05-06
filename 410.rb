x1, y1 = gets.split("\s").map(&:to_i)
x2, y2 = gets.split("\s").map(&:to_i)

p ((x2 - x1).abs + (y2 - y1).abs) / 2.0
