import re

if __name__ == '__main__':
    s = input()
    print(max(len(token) for token in re.split(r'[^…]*', s)))
