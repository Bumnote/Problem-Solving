from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

N, M, K = map(int, input().split())  # N: 기간, M: 선호도 합, K: 맥주의 종류
pq = []
for _ in range(K):
    v, c = map(int, input().split())  # v: 선호도, c: 도수
    heappush(pq, (c, -v))  # 도수는 낮은 순서, 선호도는 높은 순서

flavor = []
flag = False
while pq:
    c, v = heappop(pq)
    print(f"c = {c} / v = {v}")
    flavor.append(-v)
    if len(flavor) == N:
        if sum(flavor) >= M:
            flag = True
            break
        else:
            # 선호도가 가장 낮은 것을 pop
            heappop(flavor)

if flag:
    print(c)
else:
    print(-1)
