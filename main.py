from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
N = int(input().strip())
graph = [list(map(int, input().split())) for _ in range(N)]

## 문제 해결 부분 ##
for k in range(N):
    for i in range(N):
        for j in range(N):
            if graph[i][k] and graph[k][j]:
                graph[i][j] = 1

for i in range(N):
    for j in range(N):
        print(graph[i][j], end=" ")
    print()
