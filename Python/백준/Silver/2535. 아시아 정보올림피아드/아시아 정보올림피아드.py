from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n = int(input().rstrip())

dic = {}
pq = []
for _ in range(n):
    country, student, grade = map(int, input().split())
    if country not in dic:
        dic[country] = 0

    heappush(pq, (-grade, country, student))

cnt = 0
while pq:

    grade, c_num, s_num = heappop(pq)
    if dic[c_num] < 2:
        dic[c_num] += 1
        print(f"{c_num} {s_num}")
        cnt += 1
        if cnt == 3:
            break
    else:
        continue
