import copy, heapq

if __name__ == '__main__':
    n = int(input())
    abstract_ally = [(int(a), 0) for a in input().split()]
    enemy = [int(b) for b in input().split()]

    heapq.heapify(abstract_ally)

    answer = float('inf')
    for start in range(n):
        ally = copy.copy(abstract_ally)

        max_cnt = 0
        for diff in range(n):
            level, cnt = heapq.heappop(ally)
            i = (start + diff) % n

            heapq.heappush(ally, (level + enemy[i] // 2, cnt + 1))
            max_cnt = max(max_cnt, cnt + 1)

        answer = min(answer, max_cnt)
    
    print(answer)
