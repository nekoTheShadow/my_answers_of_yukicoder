import math, sys

a, b = map(int, input().split())

x = a + b
factors = set()
for i in range(1, math.ceil(math.sqrt(x)) + 1):
    if x % i == 0:
        factors.add(i)
        factors.add(x // i)

for c in sorted(factors):
    if a != b and b != c and c != a and (a + b) % c == 0 and (b + c) % a == 0 and (c + a) % b == 0:
        print(c)
        sys.exit(0)

print(-1)