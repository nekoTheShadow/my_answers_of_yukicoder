import string

if __name__ == '__main__':
    line = input()
    tp = tuple(string.ascii_uppercase)
    ls = []

    for i, ch in enumerate(line):
        idx = tp.index(ch) - i - 1
        while idx < 0: idx += 26
        ls.append(tp[idx])
    
    print(''.join(ls))
