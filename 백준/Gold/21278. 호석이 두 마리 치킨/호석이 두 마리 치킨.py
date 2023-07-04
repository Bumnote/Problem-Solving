from sys import stdin
from itertools import combinations

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 건물의 개수, m: 도로의 개수
INF = float("inf")
matrix = [[INF] * (n + 1) for _ in range(n + 1)]

for t in range(1, n + 1):
    matrix[t][t] = 0

for _ in range(m):
    a, b = map(int, input().split())  # a <-> b: 양방향 그래프 (1시간)
    matrix[a][b] = 1
    matrix[b][a] = 1

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                matrix[i][j] = matrix[i][k] + matrix[k][j]

res = INF
ans = []
for y, x in combinations([v for v in range(1, n + 1)], 2):
    time = 0
    for t in range(1, n + 1):
        if t != y or t != x:
            time += min(matrix[t][y], matrix[t][x])

    if res > time:
        res = time
        ans = [(y, x, res * 2)]
    elif res == time:
        ans.append((y, x, res * 2))

print(*sorted(ans)[0], sep=" ")
