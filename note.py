from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

INF = float('inf')
N, M = map(int, input().split())  # N: 분기점의 수, M: 길의 수
sight = list(map(int, input().split()))  # 0: 안 보인다. / 1: 보인다.
vertex = [[] for _ in range(N + 1)]
dist = [INF] * (N + 1)
dist[0] = 0
pq = [(0, 0)]

for _ in range(M):
    a, b, t = map(int, input().split())  # a <-> b: 시간 t
    if sight[a] ==

print(dist[N - 1])
