from sys import stdin, maxsize

input = stdin.readline

## 변수 입력 부분 ##
n, k = map(int, input().split())  # n: 사람의 수, k: 친구 관계의 개수
INF = maxsize
matrix = [[INF] * (n + 1) for _ in range(n + 1)]

for t in range(1, n + 1):
    matrix[t][t] = 0

for _ in range(k):
    a, b = map(int, input().split())  # a <-> b: 양방향
    matrix[a][b], matrix[b][a] = 1, 1

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                matrix[i][j] = matrix[i][k] + matrix[k][j]


def isTrue():
    for y in range(1, n + 1):
        for x in range(1, n + 1):
            if matrix[y][x] > 6:
                return False

    return True


print("Small World!" if isTrue() else "Big World!")
