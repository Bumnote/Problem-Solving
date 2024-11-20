from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n = int(input().rstrip())

persons = [int(input().rstrip()) for _ in range(n)]
me = persons[0]

pq = []
for person in persons[1:]:
    heappush(pq, -person)

cnt = 0
if pq:
    while True:
        person = -heappop(pq)
        if me <= person:
            me += 1
            cnt += 1
            heappush(pq, -(person - 1))

        else:
            break

print(cnt)
