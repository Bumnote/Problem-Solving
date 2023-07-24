from sys import stdin
from heapq import heapify, heappush, heappop
from collections import deque

input = stdin.readline

n, m = map(int, input().split())  # n: 주차 공간의 수, m: 차량의 수
total = 0
Rs = [0] + [int(input().strip()) for _ in range(n)]  # Rs: 주차 공간 s의 단위 무게당 요금
Wk = [0] + [int(input().strip()) for _ in range(m)]  # Wk: 차량 k의 무게
pq = [i for i in range(1, n + 1)]
cars = [0] * (m + 1)
waiting = deque()
# 2 * m: m개의 차량은 한번씩 들어오고 한번씩 나간다.
for _ in range(2 * m):
    i = int(input().strip())  # i: 출입 순서

    # 차량 i가 주차장에 들어오는 것
    if i > 0:
        # 주차할 자리가 있을 경우 -> 바로 주차한다.
        if pq:
            spot = heappop(pq)
            total += (Rs[spot] * Wk[i])  # spot 위치의 가격 * i번째 차의 무게
            cars[i] = spot
        # 주차할 자리가 없는 경우 -> 대기한다.
        else:
            waiting.append(i)

    # 차량 i가 주차장에서 나가는 것 -> 대기하던 차가 주차가 가능
    else:
        i = abs(i)
        heappush(pq, cars[i])
        # 대기 중이던 차가 있다면 -> 생겨난 자리에 바로 주차한다.
        if waiting:
            c = waiting.popleft()
            spot = heappop(pq)
            total += (Rs[spot] * Wk[c])
            cars[c] = spot

print(total)
