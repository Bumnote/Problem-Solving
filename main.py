from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n x n 행렬
A = [list(map(int, input().split())) for _ in range(n)]
B = [list(map(int, input().split())) for _ in range(n)]

## 문제 해결 부분 ##
total = 0
for i in range(n):
    for j in range(n):
        for t in range(n):
            if A[i][t] == 1 and B[t][j] == 1:
                total += 1
                break

print(total)
