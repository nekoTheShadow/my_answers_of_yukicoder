l = int(input())

x = l // 2
y = l - x
ans = x * (x - 1) // 2 + y * (y - 1) // 2

print(ans)