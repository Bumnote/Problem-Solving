from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n x m => A 행렬
A = [list(map(int, input().split())) for _ in range(n)]

m, k = map(int, input().split())  # m x k => B 행렬
B = [list(map(int, input().split())) for _ in range(m)]

C = [[0] * k for _ in range(n)]  # (n x m) x (m x k) => (n x k) 행렬

## 문제 해결 부분 ##
for i in range(n):
    for j in range(k):
        for t in range(m):
            C[i][j] += A[i][t] * B[t][j]

for elem in C:
    print(*elem, sep=" ")
