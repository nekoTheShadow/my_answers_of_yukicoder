n = int(input())
ans = 0
for x in range(n + 1):
    y = n - x
    ans = max(ans, x * (y + 1) + y)
print(ans)