from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 6)
input = stdin.readline


def dfs(cur_y, cur_x):
    # 도착 지점에 도달하면 1(한 가지 경우의 수)를 리턴
    if cur_y == n - 1 and cur_x == m - 1:
        return 1

    # 이미 방문한 적이 있다면 그 위치에서 출발하는 경우의 수를 리턴
    if dp[cur_y][cur_x] != -1:
        return dp[cur_y][cur_x]

    ways = 0
    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        if 0 <= nxt_y < n and 0 <= nxt_x < m and MAP[cur_y][cur_x] > MAP[nxt_y][nxt_x]:
            ways += dfs(nxt_y, nxt_x)

    dp[cur_y][cur_x] = ways
    return dp[cur_y][cur_x]


n, m = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(n)]
dp = [[-1] * m for _ in range(n)]
dys, dxs = [1, -1, 0, 0], [0, 0, 1, -1]

print(dfs(0, 0))
