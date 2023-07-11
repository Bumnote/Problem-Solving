from sys import stdin, maxsize

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())
INF = maxsize
cows = [[INF] * (n + 1) for _ in range(n + 1)]

for t in range(1, n + 1):
    cows[t][t] = 0

for _ in range(m):
    A, B = map(int, input().split())
    cows[B][A] = 1  # B -> A

# 플로이드 워셜 점화식 구현
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if cows[i][j] > cows[i][k] + cows[k][j]:
                cows[i][j] = cows[i][k] + cows[k][j]

ans = 0
for y in range(1, n + 1):
    flag = True
    for x in range(1, n + 1):
        # 나에게로 향하는 정점이 있거나, 나로부터 향하는 정점이 있다면 -> 순위 결정 가능 
        if (cows[y][x] == INF and cows[x][y] != INF) or cows[y][x] != INF:
            continue
        flag = False

    if flag:
        ans += 1

print(ans)
