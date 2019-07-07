import collections, functools

n, m = map(int, input().split())
d = [[-1] * n for _ in range(n)]
for _ in range(m):
    a, b, c = map(int, input().split())
    a -= 1
    b -= 1
    d[a][b] = d[b][a] = max(d[a][b], c)

@functools.lru_cache(maxsize=None)
def f(current, history):
    ans = 0
    for nxt in range(n):
        if history & (1 << nxt) == 0 and d[current][nxt] > 0:
            ans = max(ans, f(nxt, history | (1 << current)) + d[current][nxt])
    return ans

ans = max(f(current, 0) for current in range(n))
print(ans)