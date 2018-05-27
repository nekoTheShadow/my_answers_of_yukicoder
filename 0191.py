if __name__ == '__main__':
    n = int(input())
    votes = tuple(map(int, input().split()))

    bound = sum(votes) / 10
    cnt = 0
    for vote in votes:
        if vote <= bound: cnt += 1

    print(cnt * 30)
