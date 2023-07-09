from sys import stdin, maxsize

input = stdin.readline

## 변수 입력 부분 ##
n, t = map(int, input().split())  # n: 도시의 수, t: 텔레포트 시간
INF = maxsize
matrix = [[INF] * (n + 1) for _ in range(n + 1)]

for v in range(1, n + 1):
    matrix[v][v] = 0

citys = [0]  # 도시 정보를 담는다.
for _ in range(n):
    s, x, y = map(int, input().split())  # s: 텔레포트 여부, (x, y): 위치
    citys.append((s, x, y))

## 도시 거리 저장
for i in range(1, n):
    for j in range(i + 1, n + 1):
        dist = abs(citys[i][1] - citys[j][1]) + abs(citys[i][2] - citys[j][2])
        # 연결된 거리와 텔레포트 시간 중 최솟값을 선택
        if citys[i][0] == 1 and citys[j][0] == 1:
            matrix[i][j] = min(dist, t)
        else:
            matrix[i][j] = dist

        # 양방향 그래프
        matrix[j][i] = matrix[i][j]

# 플로이드 워셜 점화식 구현
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                matrix[i][j] = matrix[i][k] + matrix[k][j]

m = int(input().strip())  # m: 도시의 쌍 개수
for _ in range(m):
    a, b = map(int, input().split())  # a -> b
    print(matrix[a][b])
