import collections

if __name__ == '__main__':
    stock = collections.defaultdict(int)

    n = int(input())
    for _ in range(n):
        items = map(int, input().split())
        for item in items: stock[item] += 1
    
    ans = rest = 0
    for ky in stock:
        ans += stock[ky] // 2
        rest += stock[ky] % 2
    
    print(ans + rest // 4)
