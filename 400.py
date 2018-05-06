if __name__ == '__main__':
    line = input()
    
    tokens = []
    for s in reversed(line): tokens.append('<' if s == '>' else '>')
    
    print(''.join(tokens))
