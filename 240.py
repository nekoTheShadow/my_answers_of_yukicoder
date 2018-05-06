from itertools import product

if __name__ == '__main__':
    x, y = map(int, input().split())
    
    moves = [(i * dx, j * dy) for (i, j), (dx, dy) in product([(2, 1), (1, 2)], product([1, -1], repeat=2))]
    flg = False
    stack = [(0, 0, 0)]
    while not flg and stack:
        cnt, a, b = stack.pop()
        if cnt > 3: continue

        flg = x == a and y == b
        stack.extend((cnt + 1, a + i, b + j) for i, j in moves)
    
    print("YES" if flg else "NO")
