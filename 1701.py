n, w = map(int, input().split())
a = list(map(int, input().split()))

if w == 0:
    c = a.count(0)
    print(2**c-1)
    exit(0)

ans = set()
for bit in range(3**n):
    x = bit
    total = 0
    key = 0
    for i in range(n):
        y = x % 3
        x //= 3
        if y == 1: total += a[i]
        if y == 2: total += a[i] // 2
        if y != 0: key |= (1 << i)
    if total == w: ans.add(key)

print(len(ans))