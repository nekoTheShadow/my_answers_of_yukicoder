a, b = map(int, input().split())

if a%2 == b%2:
    print(((a+1)*(b+1)+a*b) % (10**9+7))
else:
    print(((a+1)*b+a*(b+1)) % (10**9+7))
