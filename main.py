from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # 도시의 개수
bus = int(input().strip())  # 버스의 개수
graph = [[float('inf')] * n for _ in range(n)]

for y in range(n):
    for x in range(n):
        if y == x:
            graph[y][x] = 0

for _ in range(bus):
    i, j, dist = map(int, input().split())
    graph[i - 1][j - 1] = min(graph[i - 1][j - 1], dist)

## 문제 해결 부분 ##
for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for elem in graph:
    for val in elem:
        if val == float('inf'):
            print(0, end=" ")
        else:
            print(val, end=" ")
    print()
