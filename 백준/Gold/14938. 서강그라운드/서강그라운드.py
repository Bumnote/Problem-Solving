from sys import stdin

input = stdin.readline

n, m, r = map(int, input().split())
items = list(map(int, input().split()))

INF = int(1e9)
MAP = [[INF] * (n + 1) for _ in range(n + 1)]

for t in range(1, n + 1):
    MAP[t][t] = 0  # 자기 자신으로의 거리는 0으로 초기화

for _ in range(r):
    a, b, l = map(int, input().split())  # a <-> b: 길이 l
    MAP[a][b], MAP[b][a] = l, l

# 정점 수가 적으므로, 플로이드 워셜 알고리즘 적용
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            MAP[i][j] = min(MAP[i][j], MAP[i][k] + MAP[k][j])

MAX = 0
for i in range(1, n + 1):
    item = 0
    for j in range(1, n + 1):
        if MAP[i][j] <= m:
            item += items[j - 1]

    MAX = max(MAX, item)

print(MAX)
