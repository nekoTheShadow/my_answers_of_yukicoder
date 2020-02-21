n, k = map(int, input().split())
a = [0] * (n - 1)
b = [0] * (n - 1)
for i in range(n - 1):
    a[i], b[i] = map(int, input().split())

if k <= n:
    print(k - 1)
else:
    print(-1)