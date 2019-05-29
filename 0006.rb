require "prime"

def to_hash(x)
  x = x.digits.sum until x < 10
  x
end

k = gets.to_i
n = gets.to_i

primes = Prime.each(n).select{|prime| k <= prime}.to_a

answers = Hash.new(-1)
primes.size.times do |x|
  hashes = []
  (x...primes.size).each do |y|
    hash = to_hash(primes[y])
    break if hashes.include?(hash)
    hashes << hash
  end
  answers[hashes.size] = [answers[hashes.size], x].max 
end

puts primes[answers[answers.keys.max]]