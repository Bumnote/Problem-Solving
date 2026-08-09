from sys import stdin

input = stdin.readline

n, m, k = map(int, input().split())
MAP = [list(map(int, input().strip())) for _ in range(n)]

ans, cnt = 0, 0
for i in range(n):
    cnt = 0
    for j in range(m):
        if MAP[i][j] == 0:
            cnt += 1
            if cnt == k:
                ans += 1
                cnt -= 1
        else:
            cnt = 0

print(ans)
