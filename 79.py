if __name__ == '__main__':
    n = int(input())
    levels = list(map(int, input().split()))

    countings = [0 for _ in range(7)]
    for level in levels: countings[level] += 1

    answer = 0
    for level in range(7):
        if countings[answer] <= countings[level]: answer = level
    
    print(answer)
