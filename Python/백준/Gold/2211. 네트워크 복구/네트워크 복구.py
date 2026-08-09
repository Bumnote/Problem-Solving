from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def save_trace(path):
    global ans

    for e in range(2, n + 1):
        trace = []
        curr = e
        while curr != -1:
            trace.append(curr)
            curr = path[curr]

        for i in range(len(trace) - 1, 0, -1):
            lst = sorted([trace[i], trace[i - 1]])
            ans.add(tuple(lst))


def dijkstra(s):
    INF = int(1e9)
    dist = [INF for _ in range(n + 1)]
    path = [-1 for _ in range(n + 1)]

    dist[s] = 0
    pq = [(0, s)]
    while pq:
        min_dist, cur_v = heappop(pq)

        if min_dist != dist[cur_v]:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = min_dist + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                path[nxt_v] = cur_v
                heappush(pq, (new_dist, nxt_v))

    save_trace(path)


n, m = map(int, input().split())  # 1 ≤ n ≤ 1_000
vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    vertex[a].append((b, c))
    vertex[b].append((a, c))

ans = set()
dijkstra(1)
print(len(ans))
for a, b in list(ans):
    print(f"{a} {b}")
