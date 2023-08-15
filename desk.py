from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize

n, v, e = map(int, input().split())  # n: 팀원의 수, v: 장소의 수, e: 도로의 수
a, b = map(int, input().split())  # a: KIST의 위치, b: 씨알푸드의 위치
H = list(map(int, input().split()))  # n명의 집의 위치

vertex = [[] for _ in range(v + 1)]
for _ in range(e):
    s, t, l = map(int, input().split())  # s <-> t:가중치 l 양방향
    vertex[s].append((t, l))
    vertex[t].append((s, l))


# 다익스트라 구현 함수 -> 출발지로에서 시작하여 모든 정점까지의 최단거리를 구한다.
def dijkstra(s):
    dist = [INF] * (v + 1)
    dist[s] = 0
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

    # KIST 또는 씨알푸드까지 가지 못하는 경우의 거리는 -1
    return (dist[a] if dist[a] != INF else -1) + (dist[b] if dist[b] != INF else - 1)


ans = 0
for house in H:
    ans += dijkstra(house)

print(ans)
