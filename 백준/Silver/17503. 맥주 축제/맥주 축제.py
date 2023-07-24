from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

N, M, K = map(int, input().split())  # N: 기간, M: 선호도 합, K: 맥주의 종류
pq = []
for _ in range(K):
    v, c = map(int, input().split())  # v: 선호도, c: 도수 레벨
    heappush(pq, (c, -v))  # 도수 레벨은 오름차순, 선호도는 내림차순

flavor = 0  # 선호도의 합
lst = []  # 선호도를 우선순위 큐에 담는다.
flag = False
while pq:
    c, v = heappop(pq)
    heappush(lst, -v)  # 도수 레벨이 작으면서, 선호도의 합이 큰 것부터 담는다.
    flavor -= v  # 선호도를 더해간다.
    if len(lst) == N:
        if flavor >= M:
            flag = True
            break
        else:
            flavor -= heappop(lst)  # 선호도가 가장 낮은 것을 pop한다.

if flag:
    print(c)
else:
    print(-1)
