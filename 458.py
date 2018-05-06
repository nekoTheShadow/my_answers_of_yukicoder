import math

if __name__ == '__main__':
    n = int(input())

    primes = list(range(n + 1))
    primes[0] = primes[1] = None

    ht = {0 : 0}
    for prime in primes:
        if prime is None: continue
        if prime <= math.sqrt(n):
            for non_prime in range(prime * 2, n + 1, prime): primes[non_prime] = None

        temp = {}
        for ky in sorted(ht):
            x = ky + prime
            if x > n: break
            if not x in ht or ht[x] < ht[ky] + 1: temp[x] = ht[ky] + 1
        ht.update(temp)
    
    print(ht[n] if n in ht else -1)
