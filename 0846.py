# a - 1 < n / p <= a
#  <=> p * (a - 1) < n <= p * a

# a + b - 1 < n / q <= a + b
#  <=> q * (a + b - 1) < n <= q * (a + b)

p, q, r = map(int, input().split())
a, b, c = map(int, input().split())

lo = max(p * (a - 1), q * (a + b - 1), r * (a + b + c - 1)) + 1
hi = min(p * a, q * (a + b), r * (a + b + c))

if lo <= hi:
    print(lo, hi)
else:
    print(-1)

