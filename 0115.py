# lo..hiからk個選択し、dを作れるかどうか?
def ok(lo, hi, k, d):
    if hi - lo + 1 < k:
        return False
    
    mi = 0
    mx = 0
    for i in range(k):
        mi += lo + i
        mx += hi - i
    return mi <= d <= mx

def f(n, d, k):
    if not ok(1, n, k, d):
        return [-1]
    
    lo = 1
    ans = []
    while k > 0:
        if ok(lo + 1, n, k - 1, d - lo):
            ans.append(lo)
            k -= 1
            d -= lo
        lo += 1
    
    return ans

if __name__ == '__main__':
    n, d, k = map(int, input().split())
    print(' '.join(map(str, f(n, d, k))))