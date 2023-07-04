from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, k = map(int, input().split())  # n: 사건의 개수, k: 전후 관계의 개수
INF = float('inf')
matrix = [[INF] * (n + 1) for _ in range(n + 1)]

for t in range(1, n + 1):
    matrix[t][t] = 0

for _ in range(k):
    k1, k2 = map(int, input().split())  # k1 -> k2: 단방향 그래프
    matrix[k1][k2] = 1

# 플로이드 워셜 점화실 구현
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                matrix[i][j] = matrix[i][k] + matrix[k][j]

s = int(input().strip())  # s: 사건 쌍의 수
for _ in range(s):
    s1, s2 = map(int, input().split())  # (s1, s2)
    # 두 사건의 전후관계를 모르는 경우: 0
    if matrix[s1][s2] == INF and matrix[s2][s1] == INF:
        print(0)
    # s2 -> s1 관계인 경우: 1
    elif matrix[s1][s2] == INF:
        print(1)
    # s1 -> s2 관계인 경우: -1
    else:
        print(-1)
