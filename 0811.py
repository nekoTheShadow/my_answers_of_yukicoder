import math, collections, functools

def prime_division(x):
    primes = []
    for i in range(2, math.ceil(math.sqrt(x)) + 1):
        while x % i == 0:
            primes.append(i)
            x //= i

    if x > 1:
        primes.append(x)
    return primes

def count_factor(x):
    ans = 1
    for v in collections.Counter(prime_division(x)).values():
        ans *= v + 1
    return ans

def gcd(a, b): # a < b
    while b % a != 0:
        a, b = b % a, a
    return a

if __name__ == '__main__':
    n, k = map(int, input().split())
    d = collections.defaultdict(list)
    for m in range(2, n):
        if len(prime_division(gcd(m, n))) >= k:
            d[count_factor(m)].append(m)
        
    print(min(d[max(d)]))

