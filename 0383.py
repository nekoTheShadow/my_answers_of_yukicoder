if __name__ == '__main__':
    a, b = map(int, input().split())
    diff = b - a

    tokens = []
    if diff > 0: tokens.append('+')
    if diff < 0: tokens.append('-')
    tokens.append(str(abs(diff)))

    print(''.join(tokens))
