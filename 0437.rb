class Solver

    def initialize(n)
        @digits = []
        while n > 0
            @digits << n % 10
            n /= 10
        end
        @digits.reverse!

        @memo = {}
    end

    def f(bit)
        return @memo[bit] if @memo.key?(bit)

        idxs = (0...@digits.size).each_with_object([]){|idx, arr| arr << idx if bit & (1 << idx) == 0}
        return 0 if idxs.size < 3
        
        scores = []
        idxs.combination(3) do |i, j, k|
            x = 100 * @digits[i] + 10 * @digits[j] + @digits[k]
            b = bit | (1 << i) | (1 << j) | (1 << k)
            
            score = f(b)
            score += x if @digits[i] != 0 && @digits[j] == @digits[k] && @digits[i] != @digits[j]

            scores << score
        end
        
        @memo[bit] = scores.max
    end
end


n = STDIN.gets.to_i
solver = Solver.new(n)
p solver.f(0)
