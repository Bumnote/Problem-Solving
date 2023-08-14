from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline

INF = maxsize
n, m, x = map(int, input().split())  # n: 마을 수, m: 도로 개수, x: 파티할 마을 번호
vertex = [[] for _ in range(n + 1)]

for i in range(1, m + 1):
    s, e, t = map(int, input().split())  # s -> e: 가중치 t 단방향
    vertex[s].append((e, t))

ans = [0] * (n + 1)


def dijkstra(s, e):
    global x

    dist = [INF] * (n + 1)
    dist[s] = 0  # 시작점의 위치 0으로 초기화
    pq = [(0, s)]

    while pq:
        min_dist, cur_v = heappop(pq)

        if dist[cur_v] != min_dist:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = dist[cur_v] + nxt_dist

            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    if s == x:
        return dist
    # i -> x 걸리는 시간 return
    else:
        return dist[e]


ans = dijkstra(x, -1)  # x -> 모든 마을까지 걸리는 시간

MAX_DIST = 0
for i in range(1, n + 1):
    if i == x:
        continue
    ans[i] += dijkstra(i, x)  # i -> x 까지 걸리는 시간
    if ans[i] > MAX_DIST:
        MAX_DIST = ans[i]

print(MAX_DIST)
