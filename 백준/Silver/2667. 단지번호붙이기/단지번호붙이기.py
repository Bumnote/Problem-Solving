from sys import stdin, setrecursionlimit

setrecursionlimit(2_500)
input = stdin.readline


def dfs(cur_y, cur_x):
    global cnt
    MAP[cur_y][cur_x] = 0
    cnt += 1

    dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        if 0 <= nxt_y < n and 0 <= nxt_x < n and MAP[nxt_y][nxt_x] == 1:
            dfs(nxt_y, nxt_x)


n = int(input().rstrip())

MAP = [list(map(int, input().rstrip())) for _ in range(n)]

home_cnt = []
for i in range(n):
    for j in range(n):
        if MAP[i][j] == 1:
            cnt = 0
            dfs(i, j)
            home_cnt.append(cnt)

print(len(home_cnt))
print(*sorted(home_cnt), sep='\n')
