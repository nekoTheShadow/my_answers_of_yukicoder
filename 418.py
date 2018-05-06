import re

if __name__ == '__main__':
    line = input()
    cnt = 0
    while True:
        m = re.search(r'mi-*n', line)
        if not m: break

        cnt += 1
        line = line[m.end()::]
    
    print(cnt)
