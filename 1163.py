n, x = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

for i in range(n):
    a[i] -= x

m = sum(a)
if m >= 0:
    print(0)
    exit()

if max(a) < 0:
    print(-1)
    exit()

dp = [{} for _ in range(n+1)]
dp[0][m] = 0
for i in range(n):
    for k in dp[i]:
        if k in dp[i+1]:
            dp[i+1][k] = min(dp[i+1][k], dp[i][k])
        else:
            dp[i+1][k] = dp[i][k]
        
        if k-a[i] in dp[i+1]:
            dp[i+1][k-a[i]] = min(dp[i+1][k-a[i]], dp[i][k]+b[i])
        else:
            dp[i+1][k-a[i]] = dp[i][k]+b[i]

ans = float('inf')
for k in dp[n]:
    if k >= 0:
        ans = min(ans, dp[n][k])
print(ans)