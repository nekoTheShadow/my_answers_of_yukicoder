if __name__ == '__main__':
    a, b, x, y = map(int, input().split())
    ans = (a + b) * min(x / a, y / b)
    print(ans)
