if __name__ == '__main__':
    x = input().replace('hamu', '1').replace('ham', '0')
    double = bin(int(x, 2) * 2)[2::].replace('1', 'hamu').replace('0', 'ham')
    print(double)
