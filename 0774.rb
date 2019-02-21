require 'openssl'

n = gets.to_i
a = gets.chomp.split

ans = a.permutation(n)
       .map(&:join)
       .uniq
       .sort_by{|str| str.to_i * -1}
       .find{|str| OpenSSL::BN.new(str).prime?}

puts ans || -1
