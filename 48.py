import sys, math

if __name__ == '__main__':
    x, y, l = (int(line.strip()) for line in sys.stdin)
    
    if y >= 0: cnt = 0 if x == 0 else 1
    else:      cnt = 1 if y == 0 else 2
    
    cnt += math.ceil(abs(x) / l) + math.ceil(abs(y) / l)
    print(cnt)
