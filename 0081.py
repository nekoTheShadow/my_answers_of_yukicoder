import decimal

if __name__ == '__main__':
    n = int(input())
    ans = sum(decimal.Decimal(input()) for _ in range(n))
    print('{0:.10f}'.format(ans))
