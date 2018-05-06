if __name__ == '__main__':
    n = int(input())
    numbers = tuple(sorted(map(int, input().split())))

    ans = float('inf')
    for x in range(n - 1):
        if numbers[x] != numbers[x + 1]: ans = min(ans, abs(numbers[x + 1] - numbers[x]))

    if ans == float('inf'): ans = 0
    print(ans)
