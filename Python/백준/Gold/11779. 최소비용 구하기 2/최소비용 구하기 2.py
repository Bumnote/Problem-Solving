from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def get_trace(path, e):
    trace = []
    curr = e
    while curr != -1:
        trace.append(curr)
        curr = path[curr]

    return trace[::-1]


def dijkstra(s, e):
    INF = float('inf')
    dist = [INF for _ in range(n + 1)]
    path = [-1 for _ in range(n + 1)]

    dist[s] = 0
    pq = [(0, s)]
    while pq:

        min_dist, cur_v = heappop(pq)
        if min_dist != dist[cur_v]:
            continue

        if cur_v == e:
            break

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = min_dist + nxt_dist
            if new_dist < dist[nxt_v]:
                path[nxt_v] = cur_v
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    trace = get_trace(path, e)
    return dist[e], trace


# 입력 부분
n = int(input().rstrip())
m = int(input().rstrip())

# 풀이 부분
vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    v1, v2, t = map(int, input().split())  # v1 <-> v2: 양방향 t
    vertex[v1].append((v2, t))

s, e = map(int, input().split())
dist, trace = dijkstra(s, e)

# 정답 출력
print(dist)
print(len(trace))
print(*trace)
