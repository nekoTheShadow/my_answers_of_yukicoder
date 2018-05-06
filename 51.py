if __name__ == '__main__':
    w = int(input())
    day = int(input())

    for d in range(day, 1, -1): w = w - w // d ** 2
    print(w)
