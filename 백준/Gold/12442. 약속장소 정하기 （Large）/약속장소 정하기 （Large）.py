from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize


def dijkstra(s, t):
    dist = [INF] * (n + 1)
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

    for i in range(1, n + 1):
        if dist[i] != INF:
            dist[i] *= t

    return dist[1:]


T = int(input().strip())  # T: 테스트 케이스

for tc in range(1, T + 1):
    n, p, m = map(int, input().split())  # n: 도시의 수, p: 친구의 수, m: 도로의 수
    vertex = [[] for _ in range(n + 1)]
    p_list = [tuple(map(int, input().split())) for _ in range(p)]  # (출발 정점, 거리 1당 걸리는 시간)

    # 도로 정보 입력ㄴ
    for _ in range(m):
        dj, lj, *c_list = map(int, input().split())  # dj: 도시 사이의 거리, lj: 도로를 이루는 도시 개수, c_list: 도시들의 정점
        for j in range(lj - 1):
            # 양방향
            v1, v2 = c_list[j], c_list[j + 1]
            vertex[v1].append((v2, dj))
            vertex[v2].append((v1, dj))

    ans = [0] * n
    for s, t in p_list:
        res = dijkstra(s, t)
        for h in range(n):
            ans[h] = max(ans[h], res[h])

    print(f"Case #{tc}: {min(ans) if min(ans) != INF else -1}")
