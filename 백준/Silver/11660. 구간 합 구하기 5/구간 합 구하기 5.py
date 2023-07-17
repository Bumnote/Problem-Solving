from sys import stdin

input = stdin.readline

n, m = map(int, input().split())  # n x n 행렬, m: 테스트 케이스
matrix = [list(map(int, input().split())) for _ in range(n)]
pre = [[0] * (n + 1) for _ in range(n)]

for y in range(n):
    for x in range(1, n + 1):
        pre[y][x] = pre[y][x - 1] + matrix[y][x - 1]

for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())  # (x1, y1), (x2, y2)
    ans = 0
    for y in range(x1 - 1, x2):
        ans += pre[y][y2] - pre[y][y1 - 1]

    print(ans)
