from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
# v <= 400, e <= V*(V - 1)
v, e = map(int, input().split())  # v: 마을의 개수, e: 도로의 개수
INF = float('inf')
village = [[INF] * (v + 1) for _ in range(v + 1)]

for _ in range(e):
    a, b, c = map(int, input().split())  # a -> b: 거리 c
    village[a][b] = c

## 문제 해결 부분 ##
# 플로이드 워셜 점화식 구현 
for k in range(1, v + 1):
    for i in range(1, v + 1):
        for j in range(1, v + 1):
            if village[i][j] > village[i][k] + village[k][j]:
                village[i][j] = village[i][k] + village[k][j]

dist = INF
for t in range(1, v + 1):
    if village[t][t] != INF:
        if dist > village[t][t]:
            dist = village[t][t]

print(dist if dist != INF else -1)
