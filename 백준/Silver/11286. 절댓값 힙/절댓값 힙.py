from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

cnt = int(input().strip())  # cnt: 주어지는 횟수

pq = []
for _ in range(cnt):
    n = int(input().strip())
    if n != 0:
        heappush(pq, (abs(n), n))
    else:
        if pq:
            print(heappop(pq)[1])
        # 배열이 비어있는 경우 
        else:
            print(0)
