if __name__ == '__main__':
    n, m = map(int, input().split())
    idxs = tuple(map(int, input().split()))

    cards = list(range(n + 1))
    for idx in idxs:
        card = cards[idx]
        del cards[idx]
        cards.insert(1, card)
    
    print(cards[1])
