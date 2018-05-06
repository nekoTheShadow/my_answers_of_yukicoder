import itertools, math

def lcm(a, b):
    return a * b // math.gcd(a, b)

if __name__ == '__main__':
    n = int(input())
    a, b, c = map(int, input().split())
    factors = (a, b, c)

    plus1 = sum(n // factor for factor in factors)
    minus = sum(n // lcm(f1, f2) for f1, f2 in itertools.combinations(factors, 2))
    plus2 = n // lcm(a, lcm(b, c))

    print(plus1 - minus + plus2)
