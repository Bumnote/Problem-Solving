from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize

n, m = map(int, input().split())  # n: 집의 수, m: 도로의 개수
j = int(input().strip())  # j: 진서의 집
k = int(input().strip())  # k: 동물의 수

A = list(map(int, input().split()))  # A형 집의 위치
B = list(map(int, input().split()))  # B형 집의 위치

vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    x, y, z = map(int, input().split())  # x <-> y:거리 z 양방향
    vertex[x].append((y, z))
    vertex[y].append((x, z))

dist = [INF] * (n + 1)
dist[j] = 0  # 진서의 위치를 거리 0으로 초기화
pq = [(0, j)]

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

a_d = INF
for elem in A:
    if a_d > dist[elem]:
        a_d = dist[elem]

b_d = INF
for elem in B:
    if b_d > dist[elem]:
        b_d = dist[elem]

# 둘 다 갈 수 없는 경우
if a_d == INF and b_d == INF:
    print(-1)
# B형 집이 더 가까운 경우
elif a_d > b_d:
    print("B")
    print(b_d)
# A형 집이 더 가깝거나, B형 집과 거리 차이가 없는 경우
else:
    print("A")
    print(a_d)
