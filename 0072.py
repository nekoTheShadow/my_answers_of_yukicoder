n = int(input())

ans = 0
for x in (n // 2, n // 2 + 1):
    y = n - x
    ans = max(ans, x * (y + 1) + y)

print(ans % 1000007)
