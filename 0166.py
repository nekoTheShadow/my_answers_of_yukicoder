h, w, n, k = map(int, input().split())
mod = (h * w) % n
last = n if mod == 0 else mod
print('YES' if last == k else 'NO')