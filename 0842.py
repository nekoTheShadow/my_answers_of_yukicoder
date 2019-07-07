import itertools
A, B, C, D, E, F, G = map(int, input().split())
print('YES' if any(500 * a + 100 * b + 50 * c + 10 * d + 5 * e + 1 * f == G for a, b, c, d, e, f in itertools.product(range(A + 1), range(B + 1), range(C + 1), range(D + 1), range(E + 1), range(F + 1))) else 'NO')
