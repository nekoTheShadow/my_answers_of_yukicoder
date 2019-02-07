require 'openssl'

n = gets.to_i
x = n.times.map{ gets.chomp }

n.times do |i|
  is_prime = OpenSSL::BN.new(x[i]).prime? ? 1 : 0
  puts "#{x[i]} #{is_prime}"
end

__END__

require 'openssl';gets;STDIN.each{|x| x.strip!; puts "#{x} #{OpenSSL::BN.new(x).prime? ? 1 : 0}"}
