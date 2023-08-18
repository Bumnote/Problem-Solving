from sys import stdin, maxsize

input = stdin.readline
INF = maxsize

n, m = map(int, input().split())  # n: 집하장의 개수, m: 경로의 개수
mat = [[INF] * (n + 1) for _ in range(n + 1)]
ans = [[INF] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    mat[i][i] = 0
    ans[i][i] = "-"

for _ in range(m):
    a, b, t = map(int, input().split())  # a <-> b:시간 t 양방향
    mat[a][b], mat[b][a] = t, t
    ans[a][b], ans[b][a] = b, a

# 플로이드 워셜 알고리즘 구현
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if mat[i][j] > mat[i][k] + mat[k][j]:
                mat[i][j] = mat[i][k] + mat[k][j]
                # 초기화 값인 INF인 경우에만 첫 경로인 k로 갱신
                ans[i][j] = ans[i][k]

# 정답 출력
for y in range(1, n + 1):
    for x in range(1, n + 1):
        print(ans[y][x], end=" ")
    print()

print()
for y in range(1, n + 1):
    for x in range(1, n + 1):
        print(mat[y][x], end=" ")
    print()
