import itertools

if __name__ == '__main__':
    n, m = map(int, input().split())

    matrix = [[0 for _ in range(n)] for _ in range(n)]
    for _ in range(m):
        x, y = map(int, input().split())
        matrix[x][y] = matrix[y][x] = 1

    cnt = 0
    for points in itertools.combinations(range(n), 4):
        totals = [sum(matrix[start][other] for other in points) for start in points]
        if all(total == 2 for total in totals): cnt += 1

    print(cnt)
