from sys import stdin

input = stdin.readline

v, e = map(int, input().split())

INF = int(1e9)
MAP = [[INF] * (v + 1) for _ in range(v + 1)]

for t in range(1, v + 1):
    MAP[t][t] = 0

for _ in range(e):
    a, b, c = map(int, input().split())
    MAP[a][b] = c  # a -> b: 가중치 c

# 플로이드 워셜 점화식
for k in range(1, v + 1):
    for i in range(1, v + 1):
        for j in range(1, v + 1):
            MAP[i][j] = min(MAP[i][j], MAP[i][k] + MAP[k][j])  # 최단 경로 갱신

min_cycle = INF

for i in range(1, v + 1):
    for j in range(i + 1, v + 1):
        dist = MAP[i][j] + MAP[j][i]  # i -> j -> i 왕복 거리
        min_cycle = min(min_cycle, dist)

print(min_cycle if min_cycle < INF else -1)
