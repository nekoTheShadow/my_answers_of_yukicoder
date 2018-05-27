import sys, copy

if __name__ == '__main__':
    n = int(input())
    weights = [int(token) for token in input().split(' ')]

    total = sum(weights)
    if total % 2 != 0:
        print("impossible")
        sys.exit(0)

    dest = total // 2
    ht = {}

    for weight in weights:
        temp = copy.deepcopy(ht)
        
        for ky in ht: temp[ky + weight] = True
        temp[weight] = True

        ht = temp
        if dest in ht: break
    
    print("possible" if dest in ht else "impossible")
