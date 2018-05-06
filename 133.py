import itertools

if __name__ == '__main__':
    n = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    numer = denom = 0
    for a_cards, b_cards in itertools.product(itertools.permutations(a), itertools.permutations(b)):
        a_win = b_win = draw = 0
        for i in range(n):
            a_card, b_card = a_cards[i], b_cards[i]
            if a_card >  b_card: a_win += 1
            if a_card == b_card: draw += 1
            if a_card <  b_card: b_win += 1
        
        if a_win > b_win: numer += 1
        denom += 1
    
    print(numer / denom)
