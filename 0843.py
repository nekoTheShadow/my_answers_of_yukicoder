import math

n = int(input())
sieve = list(range(n + 1))
sieve[0] = sieve[1] = None
for x in range(2, math.ceil(math.sqrt(n)) + 1):
    if sieve[x] is not None:
        for y in range(x + x, n + 1, x):
            sieve[y] = None

count = 0
primes = set(x for x in sieve if x is not None)
for q in primes:
    x = q + 2
    r = math.ceil(math.sqrt(x))
    if r * r == x and r in primes:
        if q == 2:
            count += 1
        else:
            count += 2

print(count)