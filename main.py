from sys import stdin, maxsize

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 컴퓨터의 개수, m: 회선의 개수
INF = float('inf')
network = [[INF] * (n + 1) for _ in range(n + 1)]

for t in range(1, n + 1):
    network[t][t] = 0

for _ in range(m):
    A, B, C = map(int, input().split())  # A <-> B: 통신 시간 C
    network[A][B] = C
    network[B][A] = C

# 플로이드 워셜 점화식 구현
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if network[i][j] > network[i][k] + network[k][j]:
                network[i][j] = network[i][k] + network[k][j]

ans = 0
temp = INF
for v in range(1, n + 1):
    if temp > sum(network[v][1:]):
        temp = sum(network[v][1:])
        ans = v

print(ans)
