if __name__ == '__main__':
    l = int(input())
    n = int(input())
    tokens = input().split()

    token = tokens[0]
    ans = 2 ** (l - len(token)) * n

    print(ans)
