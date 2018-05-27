def solve(matrix):
    pivot_x, pivot_y = matrix[0]
    pivot = pivot_y - pivot_x

    for x, y in matrix:
        if x >= y or y - x != pivot: return -1

    return pivot

if __name__ == '__main__':
    n = int(input())
    matrix = tuple(tuple(map(int, input().split())) for _ in range(n))

    print(solve(matrix))
