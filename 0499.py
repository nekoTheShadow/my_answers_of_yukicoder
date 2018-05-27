if __name__ == '__main__':
    n = int(input())

    digits = []
    while n > 0:
        digits.append(n % 7)
        n //= 7

    answer = 0
    for digit in reversed(digits):
        answer = answer * 10 + digit

    print(answer)
