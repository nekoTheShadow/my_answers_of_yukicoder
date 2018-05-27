def f(x, base):
    tokens = []
    while x > 0:
        tokens.append(x % base)
        x //= base
    return ''.join(str(token) for token in reversed(tokens))

if __name__ == '__main__':
    a = int(input())

    ans = -1
    for base in range(2, a + 1):
        if f(a, base) == '17':
            ans = base
            break
    
    print(ans)
