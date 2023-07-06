from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 구슬의 개수(홀수), m: 저울에 올려 본 쌍의 개수
INF = float('inf')
matrix = [[INF] * (n + 1) for _ in range(n + 1)]

for t in range(1, n + 1):
    matrix[t][t] = 0

for _ in range(m):
    A, B = map(int, input().split())  # A > B: B -> A
    matrix[B][A] = 1

# 플로이드 워셜 점화식 구현
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                matrix[i][j] = matrix[i][k] + matrix[k][j]

ans = 0
flag = (n + 1) // 2
for y in range(1, n + 1):
    more = 0
    less = 0
    for x in range(1, n + 1):
        # 자신보다 무게가 작은 구슬의 개수가 절반보다 크면 -> 적어도 중간 무게는 아니다.
        if matrix[y][x] == INF and matrix[x][y] != INF:
            less += 1
        # 자신보다 무게가 큰 구슬의 개수가 절반보다 크면 -> 적어도 중간 무게는 아니다.
        elif matrix[y][x] != 0 and matrix[y][x] != INF:
            more += 1

    if flag <= less or flag <= more:
        ans += 1

print(ans)
