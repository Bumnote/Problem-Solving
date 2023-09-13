from sys import stdin, maxsize
from heapq import heappush, heappop

INF = maxsize
input = stdin.readline


# 다익스트라 알고리즘 구현
def dijkstra(s):
    dist = [INF] * (n + 1)
    dist[s] = 0
    pq = [(0, s)]

    while pq:
        min_dist, cur_v = heappop(pq)
        if min_dist != dist[cur_v]:
            continue

        for nxt_v, nxt_dist in vertex[cur_v].items():
            new_dist = dist[cur_v] + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    # 왕복 거리를 출력 
    return max(dist[1:]) * 2


# n: 농장의 개수, m: 도로의 개수, x: 파티가 열리는 농장
n, m, x = map(int, input().split())
vertex = [{} for _ in range(n + 1)]

for _ in range(m):
    ai, bi, ti = map(int, input().split())  # ai <-> bi:시간 ti 양방향
    if bi not in vertex[ai]:
        vertex[ai][bi] = ti
        vertex[bi][ai] = ti
    # 기존의 거리보다 짧은 시간이 걸린다면 -> 더 짧은 시간으로 갱신
    else:
        vertex[ai][bi] = min(vertex[ai][bi], ti)
        vertex[bi][ai] = min(vertex[bi][ai], ti)

print(dijkstra(x))
