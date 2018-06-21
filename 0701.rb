def main(n)
  if n == 1
    puts "n"
    return
  end

  cnt = 0
  (1..Float::INFINITY).each do |i|
    [*'a'..'z'].repeated_permutation(i) do |chars|
      puts "a#{chars.join}a"
      cnt += 1
      if cnt == n - 1
        puts "an"
        return
      end
    end
  end
end


n = gets.to_i
main(n)