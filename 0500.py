import math, sys

if __name__ == '__main__':
    n = int(input())

    if n > 100:
        answer = ''.join('0' for _ in range(12))
        print(answer)
        sys.exit()

    answer = math.factorial(n)
    display = answer % (10 ** 12)
    print(display if math.floor(math.log10(answer)) < 12 else '{0:012d}'.format(display))
