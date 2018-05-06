if __name__ == '__main__':
    line = input()

    left_cnt = line.count('(^^*)')
    right_cnt = line.count('(*^^)')

    print(left_cnt, right_cnt)
