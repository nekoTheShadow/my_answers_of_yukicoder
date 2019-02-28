n = int(input())
clist = []
dlist = []
for _ in range(n):
    c, d = map(int, input().split())
    clist.append(c)
    dlist.append(d)

ans = 0
for c, d in zip(clist, dlist):
    e = c // 2 if c % 2 == 0 else c // 2 + 1
    ans += e * d

print(ans % (10 ** 9 + 7))