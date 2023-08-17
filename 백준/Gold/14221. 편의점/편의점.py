from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize

n, m = map(int, input().split())  # n: 정점의 개수, m: 간선의 개수
vertex = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())  # a <-> b:가중치 c 양방향
    vertex[a].append((b, c))
    vertex[b].append((a, c))

p, q = map(int, input().split())  # p: 집 후보지의 개수, q: 편의점의 개수
p_list = list(map(int, input().split()))  # p_list: 집 정점번호 리스트
q_list = list(map(int, input().split()))  # q_list: 편의점 정점번호 리스트

dist = [INF] * (n + 1)
pq = []
for store in q_list:
    dist[store] = 0
    heappush(pq, (0, store))

ans = 0
# 다익스트라 알고리즘 구현
while pq:
    min_dist, cur_v = heappop(pq)
    if dist[cur_v] != min_dist:
        continue

    # 3개의 편의점 중에서 가장 먼저 집에 도착한다 -> 가장 짧은 거리 (우선 순위 큐 성질)
    if cur_v in p_list:
        ans = cur_v
        break

    for nxt_v, nxt_dist in vertex[cur_v]:
        new_dist = dist[cur_v] + nxt_dist

        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist
            heappush(pq, (new_dist, nxt_v))

print(ans)
