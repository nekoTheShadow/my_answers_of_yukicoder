import itertools

if __name__ == '__main__':
    w, h, c = (int(token) if x != 2 else token for x, token in enumerate(input().split()))

    matrix = [[None for _ in range(w)] for _ in range(h)]
    matrix[0][0] = c

    for x in range(1, h): matrix[x][0] = 'B' if matrix[x - 1][0] == 'W' else 'W'
    for x, y in itertools.product(range(h), range(1, w)): matrix[x][y] = 'B' if matrix[x][y - 1] == 'W' else 'W'
    
    print('\n'.join(''.join(row) for row in matrix))
