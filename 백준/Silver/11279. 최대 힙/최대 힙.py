from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n = int(input().rstrip())  # n: 연산의 개수

pq = []
for _ in range(n):
    x = int(input().rstrip())
    if x >= 1:
        heappush(pq, -x)
    else:
        # 원소가 존재하는 경우
        if pq:
            print(-heappop(pq))
        # 원소가 존재하지 않는 경우
        else:
            print(0)
