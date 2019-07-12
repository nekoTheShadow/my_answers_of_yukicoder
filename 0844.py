import collections

n, m, a = map(int, input().split())
e = collections.defaultdict(list)
for _ in range(m):
    l, r, p = map(int, input().split())
    e[r].append((l - 1, p))


dp = [-float('inf')] * (n + 1)
dp[0] = 0
maximum = 0
for r in range(1, n + 1):
    dp[r] = max(dp[r], maximum - a)
    for l, p in e[r]:
        if r == n:
            dp[r] = max(dp[r], dp[l] + p) 
        else:
            dp[r] = max(dp[r], dp[l] + p - a) 
    maximum = max(maximum, dp[r])

print(maximum)
