from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n = int(input().rstrip())

pq = []
for _ in range(n):
    c = int(input().rstrip())
    if c == 0:
        if not pq:
            print(0)
        else:
            print(heappop(pq))
    else:
        heappush(pq, c)
