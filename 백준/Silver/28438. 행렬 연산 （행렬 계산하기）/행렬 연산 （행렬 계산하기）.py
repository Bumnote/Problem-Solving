from sys import stdin

input = stdin.readline

N, M, Q = map(int, input().split())  # N x M 행렬, Q: 연산 개수
R = [0] * N  # R행 배열
C = [0] * M  # C열 배열
for _ in range(Q):
    a, b, v = map(int, input().split())  # 1 r v / 2 c v
    # a == 1 -> b번째 행의 모든 원소에 v를 더한다.
    if a == 1:
        R[b - 1] += v
    # a == 2 -> b번째 열의 모든 원소에 v를 더한다.
    else:
        C[b - 1] += v

for y in range(N):
    for x in range(M):
        print(R[y] + C[x], end=" ")
    print()
