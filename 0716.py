if __name__ == '__main__':
    n = int(input())
    points = list(map(int, input().split()))

    minimum = min(abs(points[i] - points[i - 1]) for i in range(len(points)))
    maximum = abs(points[0] - points[-1])

    print(minimum)
    print(maximum)