from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 파티장의 크기, m: 요청한 손님의 수
matrix = [list(map(int, input().split())) for _ in range(n)]  # (i, j) : i -> j 직접적으로 걸리는 시간

# 플로이드 워셜 점화식 구현
for k in range(n):
    for i in range(n):
        for j in range(n):
            if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                matrix[i][j] = matrix[i][k] + matrix[k][j]

for _ in range(m):
    A, B, C = map(int, input().split())  # A: 현재 파티장 번호, B: 다음 파티장 번호, C: 파티가 열리는 시간
    if matrix[A - 1][B - 1] <= C:
        print("Enjoy other party")
    else:
        print("Stay here")
