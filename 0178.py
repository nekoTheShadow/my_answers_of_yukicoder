def main():
    n = int(input())
    alist, blist = [], []
    for _ in range(n):
        a, b = map(int, input().split())
        alist.append(a)
        blist.append(b)

    ans = 0
    dlist = list(sorted(a + 4 * b for a, b in zip(alist, blist)))
    for d in dlist:
        diff = dlist[-1] - d
        if diff % 2 == 0:
            ans += diff // 2
        else:
            return -1
        
    return ans

if __name__ == '__main__':
    print(main())