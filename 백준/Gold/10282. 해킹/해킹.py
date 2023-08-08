from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

T = int(input().strip())  # T: 테스트 케이스
INF = float('inf')

for _ in range(T):
    # n: 컴퓨터 개수, d: 의존성 개수, c: 해킹당한 컴퓨터 번호
    n, d, c = map(int, input().split())
    vertex = [[] for _ in range(n + 1)]
    dist = [INF] * (n + 1)
    dist[c] = 0
    pq = [(0, c)]
    for _ in range(d):
        a, b, s = map(int, input().split())  # b -> a: s초
        vertex[b].append((a, s))

    # 다익스트라 알고리즘 구현
    while pq:
        min_dist, cur_v = heappop(pq)

        if dist[cur_v] != min_dist:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = dist[cur_v] + nxt_dist

            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    ans, cnt = 0, 0
    for d in dist[1:]:
        # 해킹을 당했다면 -> 개수 증가, 최댓값이라면 거리 갱신 
        if d != INF:
            cnt += 1
            ans = max(ans, d)

    print(cnt, ans)
