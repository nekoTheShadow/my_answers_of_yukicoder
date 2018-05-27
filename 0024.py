if __name__ == '__main__':
    memo = [True for _ in range(10)]

    n = int(input())
    for _ in range(n):
        *numbers, r = (int(token) if token.isdigit() else token for token in input().split())
        st = set(numbers) if r == 'NO' else set(range(10)).difference(set(numbers))
        for x in st: memo[x] = False
    
    print(memo.index(True))
