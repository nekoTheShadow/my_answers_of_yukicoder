if __name__ == '__main__':
    n, m = map(int, input().split())
    shirts = list(input())
    pants = list(input())

    a = min(shirts.count('A'), pants.count('A'))
    b = min(shirts.count('B'), pants.count('B'))
    print(a + b)
