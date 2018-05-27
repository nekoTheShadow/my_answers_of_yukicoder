if __name__ == '__main__':
    n, k = map(int, input().split())

    ans = n // (k + 1) + 1
    print(ans)
