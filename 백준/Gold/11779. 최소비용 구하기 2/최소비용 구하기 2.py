from sys import stdin, maxsize
from heapq import heappush, heappop
from collections import deque

input = stdin.readline
INF = maxsize

n = int(input().strip())  # n: 도시의 개수
m = int(input().strip())  # m: 버스의 개수
vertex = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())  # a -> b:요금 c 단방향
    vertex[a].append((b, c))

s, t = map(int, input().split())  # s: 출발지, t: 도착지

path = [0] * (n + 1)
dist = [INF] * (n + 1)
dist[s] = 0
pq = [(0, s)]

while pq:
    min_dist, cur_v = heappop(pq)

    if dist[cur_v] != min_dist:
        continue

    for nxt_v, nxt_dist in vertex[cur_v]:
        new_dist = dist[cur_v] + nxt_dist

        # 더 짧은 거리로 갱신되는 경우
        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist
            path[nxt_v] = cur_v  # 다음 위치에 현재 위치를 저장
            heappush(pq, (new_dist, nxt_v))

print(dist[t])  # 최소 비용
x = t
ans = deque([t])
while x != s:
    ans.appendleft(path[x])
    x = path[x]
print(len(ans))  # 최소 비용을 갖는 경로의 도시의 개수
print(*ans)  # 경로
