import collections

def f(n):
    que = collections.deque([(1, 1)])
    ht = {}
    
    while que:
        x, cnt = que.popleft()

        if x == n: return cnt

        if x in ht: continue
        ht[x] = cnt

        bit = bin(x).count("1")
        if 1 <= x + bit <= n: que.append((x + bit, cnt + 1))
        if 1 <= x - bit <= n: que.append((x - bit, cnt + 1))
    
    return -1

if __name__ == "__main__":
    n = int(input())
    print(f(n))
