from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
# (1 <= n <= 100 -> 플로이드 워셜 가능), (1 <= m <= 15), (1 <= r <= 100)
n, m, r = map(int, input().split())  # n: 지역의 개수, m: 수색 범위, r: 길의 개수
items = [0] + list(map(int, input().split()))  # n개의 아이템의 수들
INF = float('inf')
area = [[INF] * (n + 1) for _ in range(n + 1)]  # 양방향 그래프 = 대칭 행렬

for t in range(1, n + 1):
    area[t][t] = 0

# 가중치가 다르므로 인접행렬 구현
for _ in range(r):
    a, b, l = map(int, input().split())  # a <-> b: 양방향 그래프, 길이 l
    area[a][b] = l
    area[b][a] = l

# 플로이드 워셜 점화식 구현
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if area[i][j] > area[i][k] + area[k][j]:
                area[i][j] = area[i][k] + area[k][j]

ans = 0
for y in range(1, n + 1):
    total = 0
    for x in range(1, n + 1):
        # 수색 범위 이하이면 -> 아이템 획득 가능
        if area[y][x] <= m:
            total += items[x]
    if ans < total:
        ans = total

print(ans)
