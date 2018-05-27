import math

if __name__ == '__main__':
    n = int(input())

    cnt = 0
    prime = 0
    for prime in range(2, int(math.sqrt(n)) + 1):
        while n % prime == 0:
            cnt += 1
            n //= prime
    
    if n != 1: cnt += 1
    print("YES" if cnt >= 3 else "NO")
