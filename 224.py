import sys

if __name__ == '__main__':
    n, line1, line2 = sys.stdin

    x = sum(1 if s1 != s2 else 0 for s1, s2 in zip(line1, line2))
    print(x)
