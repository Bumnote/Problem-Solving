from sys import stdin, maxsize

input = stdin.readline


def get_dist(a1, b1, a2, b2):
    return abs(a1 - a2) + abs(b1 - b2)


## 변수 입력 부분 ##
xs, ys = map(int, input().split())  # (xs, ys): 수빈이 위치
xe, ye = map(int, input().split())  # (xe, ye): 집의 위치
INF = maxsize
matrix = [[INF] * 8 for _ in range(8)]  # 8개의 정점이 존재
vertex = [(xs, ys), (xe, ye)]

for t in range(8):
    matrix[t][t] = 0

for s, e in zip([2, 4, 6], [3, 5, 7]):
    x1, y1, x2, y2 = map(int, input().split())  # (x1, y1) <-> (x2, y2)
    vertex.append((x1, y1))
    vertex.append((x2, y2))
    matrix[s][e], matrix[e][s] = (10, 10)  # 텔레포트 - 10초

    for v in range(2):
        dist_1 = get_dist(*vertex[v], *vertex[s])
        dist_2 = get_dist(*vertex[v], *vertex[e])
        matrix[s][v], matrix[v][s] = (dist_1, dist_1)
        matrix[e][v], matrix[v][e] = (dist_2, dist_2)

for i in range(2, 7):
    for j in range(i + 1, 8):
        dist = get_dist(*vertex[i], *vertex[j])
        matrix[i][j], matrix[j][i] = min(matrix[i][j], dist), min(matrix[j][i], dist)

## 문제 해결 부분 ##
dist_0 = get_dist(*vertex[0], *vertex[1])
matrix[0][1], matrix[1][0] = (dist_0, dist_0)  # 수빈이와 집까지 거리

# 플로이드 워셜 점화식 구현
for k in range(8):
    for i in range(8):
        for j in range(8):
            if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                matrix[i][j] = matrix[i][k] + matrix[k][j]

print(matrix[0][1])
