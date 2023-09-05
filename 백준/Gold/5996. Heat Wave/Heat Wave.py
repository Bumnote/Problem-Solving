from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize


# 다익스트라 알고리즘 구현 
def dijkstra(i, j):
    dist = [INF] * (t + 1)
    dist[i] = 0
    pq = [(0, i)]

    while pq:
        min_dist, cur_v = heappop(pq)
        if dist[cur_v] != min_dist:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = dist[cur_v] + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    return dist[j]


t, c, ts, te = map(int, input().split())  # t: 마을의 수, c: 연결 수 , ts: 시점, te: 종점
vertex = [[] for _ in range(t + 1)]
for _ in range(c):
    r1, r2, c = map(int, input().split())
    vertex[r1].append((r2, c))
    vertex[r2].append((r1, c))

# ts 마을에서 -> te 마을까지의 최단 거리를 출력 
print(dijkstra(ts, te))
