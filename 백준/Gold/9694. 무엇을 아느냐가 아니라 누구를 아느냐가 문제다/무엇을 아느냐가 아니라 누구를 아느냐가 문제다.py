from sys import stdin, maxsize
from heapq import heappush, heappop
from collections import deque

input = stdin.readline
INF = maxsize

tc = int(input().strip())  # tc: 테스트 케이스

for t in range(1, tc + 1):
    n, m = map(int, input().split())  # n: 관계 수, m: 정치인 수
    # 0: 한신 / m - 1: 최고 의원
    vertex = [[] for _ in range(m)]

    for _ in range(n):
        x, y, z = map(int, input().split())  # x <-> y:친밀도 z 양방향
        vertex[x].append((y, z))
        vertex[y].append((x, z))

    path = [0] * m  # 경로 추적 리스트
    dist = [INF] * m  # 최단 거리 저장 리스트
    dist[0] = 0
    pq = [(0, 0)]  # 우선 순위 큐 활용

    while pq:
        min_dist, cur_v = heappop(pq)

        if dist[cur_v] != min_dist:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = dist[cur_v] + nxt_dist

            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                path[nxt_v] = cur_v
                heappush(pq, (new_dist, nxt_v))

    # 최고 의원까지 갈 수 있는 경우
    if dist[-1] != INF:
        print(f"Case #{t}: ", end="")
        x = m - 1
        ans = deque([x])
        while x != 0:
            x = path[x]
            ans.appendleft(x)
        print(*ans)
    # 최고 의원까지 갈 수 없는 경우
    else:
        print(f"Case #{t}: -1")
