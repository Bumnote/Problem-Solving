from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n = int(input().strip())  # n: 후보의 수

total = 0
pq = []
target = None
for i in range(1, n + 1):
    num = int(input().strip())  # num: 기호 i번을 뽑으려는 수
    if i == 1:
        target = num
    else:
        heappush(pq, (-num, i))

while pq:
    cur_n, cur_i = heappop(pq)
    if target > -cur_n:
        break

    heappush(pq, (cur_n + 1, cur_i))
    target += 1
    total += 1

print(total)
