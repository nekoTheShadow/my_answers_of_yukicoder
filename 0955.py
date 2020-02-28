import decimal

a, b, c = map(int, input().split())
if a == 0:
    if b == 0:
        if c == 0:
            print(-1)
        else:
            print(0)
    else:
        print(1)
        print(-c / b)
else:
    a = decimal.Decimal(a)
    b = decimal.Decimal(b)
    c = decimal.Decimal(c)
    d = b ** 2 - 4 * a * c
    if d > 0:
        p = (-b - d.sqrt()) / (2 * a)
        q = (-b + d.sqrt()) / (2 * a)
        print(2)
        print(min(p, q))
        print(max(p, q))
    elif d == 0:
        print(1)
        print(-b / (2 * a))
    else:
        print(0)