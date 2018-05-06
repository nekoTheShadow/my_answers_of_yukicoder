if __name__ == '__main__':
    line = input()
    numbers = [0 if token == '?' else int(token) for token in line.split()]

    x = numbers.index(0)
    answers = []
    for number in (1, 4):
        numbers[x] = number
        if numbers[1] in (max(numbers), min(numbers)):
            answers.append(number)
    
    print(''.join(map(str, answers)))
