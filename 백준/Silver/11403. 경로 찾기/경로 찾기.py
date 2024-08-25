from sys import stdin

input = stdin.readline

n = int(input().rstrip())  # n: 정점의 개수
uf = [i for i in range(n + 1)]

MAP = []
INF = int(1e9)
dist = [[INF] * n for _ in range(n)]
for i in range(n):
    MAP.append(list(map(int, input().split())))
    for j in range(n):
        if MAP[i][j] == 1:
            dist[i][j] = 1

# 플로이드 워셜 점화식 
for k in range(n):
    for i in range(n):
        for j in range(n):
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

for i in range(n):
    for j in range(n):
        # 갈 수 있는 곳이라면 -> 1 출력 
        if dist[i][j] != INF:
            print(1, end=" ")
        # 갈 수 없는 곳이라면 -> 0 출력
        else:
            print(0, end=" ")
    print()
