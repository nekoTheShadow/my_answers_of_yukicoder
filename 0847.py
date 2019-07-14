import math, collections, functools

n, k, m = map(int, input().split())

d = collections.defaultdict(int)
for i in range(2, math.ceil(math.sqrt(n)) + 1):
    while n % i == 0:
        d[i] += 1
        n //= i
if n > 1:
    d[n] += 1

p = list(sorted(d.keys())) # 素数
q = [d[i] * k for i in p]      # 指数

# x: 添え字
# y: 合計
@functools.lru_cache(maxsize=None)
def f(x, y):
    if x == len(p):
        return 1
    
    t = 0
    z = 1
    for i in range(q[x] + 1):
        z = y * (p[x] ** i)
        if m < z:
            break
        t += f(x + 1, z)
    return t

print(f(0, 1))