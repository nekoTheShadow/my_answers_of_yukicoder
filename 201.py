if __name__ == '__main__':
    player1, token1, _ = input().split()
    player2, token2, _ = input().split()

    point1, point2 = int(token1), int(token2)
    if point1 == point2: print(-1)
    if point1 >  point2: print(player1)
    if point1 <  point2: print(player2)
