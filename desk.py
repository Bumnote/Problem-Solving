from sys import stdin, maxsize

input = stdin.readline
INF = maxsize

n, m = map(int, input().split())  # n: 집하장의 개수, m: 경로의 개수
mat = [[INF] * (n + 1) for _ in range(n + 1)]
ans = [[0] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    mat[i][i] = 0
    ans[i][i] = "-"

for _ in range(m):
    a, b, t = map(int, input().split())  # a <-> b:시간 t 양방향
    mat[a][b], mat[b][a] = t, t
    ans[a][b], ans[b][a] = b, a

# 정답 출력
for y in range(1, n + 1):
    for x in range(1, n + 1):
        print(ans[y][x], end=" ")
    print()

print()
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if mat[i][j] > mat[i][k] + mat[k][j]:
                mat[i][j] = mat[i][k] + mat[k][j]
                # i -> j보다 i -> k -> j가 더 빠르다면 -> [i][j] 위치에 [i][k] 값 저장
                ans[i][j] = ans[i][k]
                print(f"{i} -> {k} -> {j}")
                print(f"ans[{i}][{j}] = {ans[i][j]} / ans[{i}][{k}] = {ans[i][k]}")

# 정답 출력
for y in range(1, n + 1):
    for x in range(1, n + 1):
        print(ans[y][x], end=" ")
    print()
