from sys import stdin

input = stdin.readline

INF = float('inf')

# (1 <= P <= 500 / 1 <= F_i <= P / 1 <= C <= 8_000)
P, F, C = map(int, input().split())  # P: 목초지 번호, C: 암소 경로
MAP = [[INF] * P for _ in range(P)]
for t in range(P):
    MAP[t][t] = 0

# 가장 좋아하는 F_i를 찾자.
F_i = [int(input().strip()) for _ in range(F)]
for _ in range(C):
    a_i, b_i, T_i = map(int, input().split())  # a_i <-> b_i: 양방향 T_i 시간
    MAP[a_i - 1][b_i - 1] = T_i
    MAP[b_i - 1][a_i - 1] = T_i

# 플로이드 워셜 점화식 구현
for k in range(P):
    for i in range(P):
        for j in range(P):
            if MAP[i][j] > MAP[i][k] + MAP[k][j]:
                MAP[i][j] = MAP[i][k] + MAP[k][j]

temp = INF
spot = 0
for i in range(P):
    SUM = 0
    for j in F_i:
        SUM += MAP[i][j - 1]
    if SUM < temp:
        temp = SUM
        spot = i + 1

print(spot)
