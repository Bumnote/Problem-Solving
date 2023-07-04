from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
# (5 <= n <= 100), (0 <= m <= 2_000)
n = int(input().strip())  # 물건의 개수 (무게가 서로 다르다.)
m = int(input().strip())  # 물건 쌍의 개수
INF = float('inf')
stuff = [[INF] * (n + 1) for _ in range(n + 1)]

for t in range(1, n + 1):
    stuff[t][t] = 0

for _ in range(m):
    i1, i2 = map(int, input().split())  # i1 -> i2: 단방향 그래프
    stuff[i1][i2] = 1

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if stuff[i][j] > stuff[i][k] + stuff[k][j]:
                stuff[i][j] = stuff[i][k] + stuff[k][j]

for y in range(1, n + 1):
    cnt = 0
    for x in range(1, n + 1):
        # 물건을 셀 수 없는 경우 -> 해당 노드와 비교한 적이 없는 노드가 있을 경우
        if stuff[y][x] == INF and stuff[x][y] == INF:
            cnt += 1
    print(cnt)
