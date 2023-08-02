from sys import stdin

input = stdin.readline

N = int(input().strip())  # N: 교차로의 숫자
INF = float('inf')
mat = [[INF] * N for _ in range(N)]

for i in range(N - 1):
    M = int(input().strip())  # i번째 교차로와 연결된 교차로의 개수
    C = list(map(int, input().split()))  # i번째에서 갈 수 있는 교차로의 번호
    for node in C:
        mat[i][node - 1] = 1  # i -> node 단방향 그래프

# 플로이드 워셜 점화식 구현
for k in range(N):
    for i in range(N):
        for j in range(N):
            if mat[i][j] > mat[i][k] + mat[k][j]:
                mat[i][j] = mat[i][k] + mat[k][j]

flag = False
for t in range(N):
    # 출발지와 연결이 되어있고, 해당 지점이 사이클이 존재한다면 -> flag: True
    if mat[0][t] != INF and mat[t][t] != INF:
        flag = True
        break

if flag:
    print("CYCLE")
else:
    print("NO CYCLE")
