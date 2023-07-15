from sys import stdin, maxsize

input = stdin.readline

## 변수 입력 부분 ##
n, w, p = map(int, input().split())  # n: 정점의 개수, w: 간선의 개수, p: 테스트 케이스
INF = maxsize
networks = [[INF] * (n + 1) for _ in range(n + 1)]

for t in range(1, n + 1):
    networks[t][t] = 0

for _ in range(w):
    s, e, v = map(int, input().split())  # s <-> e: 가중치 v
    networks[s][e], networks[e][s] = v, v  # 양방향 그래프

## 문제 해결 부분 ## 
# 플로이드 워셜 점화식 구현
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if networks[i][j] > networks[i][k] + networks[k][j]:
                networks[i][j] = networks[i][k] + networks[k][j]

for _ in range(p):
    a, b = map(int, input().split())
    print(networks[a][b])
