import itertools

n = int(input())
if n == 1:
    for a, b, c, d, e, f, g, h in itertools.permutations(range(10), r=8):
        if a == 0 or d == 0 or b == 0:
            continue
        x =          100*a + 10*b + c
        y =          100*d + 10*e + f
        z = 1000*b + 100*g + 10*h + b
        if x+y == z:
            print(z)
            exit(0)

if n == 2:
    for a, b, c, d, e, f, g, h, i, j in itertools.permutations(range(10)):
        if a == 0 or d == 0 or h == 0:
            continue
        x =           1000*a + 100*a + 10*b + c
        y =           1000*d + 100*e + 10*f + g
        z = 10000*h + 1000*i + 100*b + 10*c + j
        if x+y == z:
            print(z)
            exit(0)

if n == 3:
    for c, e, g, h, i, n, p, r, s, t in itertools.permutations(range(10)):
        if s == 0 or e == 0 or p == 0:
            continue
        x = 100000*s + 10000*p + 1000*r + 100*i + 10*n + g
        y =            10000*e + 1000*i + 100*g + 10*h + t
        z = 100000*p + 10000*i + 1000*c + 100*n + 10*i + c
        if x+y == z:
            print(z)
            exit(0)