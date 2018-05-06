if __name__ == '__main__':
    x = y = 0

    n = int(input())
    for _ in range(n):
        t, s = input().split()
        
        l = len(s)
        m = min(l, int(t) * 12 // 1000)
        x += m
        y += l - m
    
    print(x, y)
