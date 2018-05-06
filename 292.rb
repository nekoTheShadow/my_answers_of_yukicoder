s, t, u = gets.split
s[t.to_i] = s[u.to_i] = "@"
puts s.delete("@")
