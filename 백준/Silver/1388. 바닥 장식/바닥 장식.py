from sys import stdin

input = stdin.readline

N, M = map(int, input().split())  # N x M MAP
MAP = [list(input().strip()) for _ in range(N)]


def dfs(y, x, s):
    # 가로로만 움직이는 경우
    if s == "-":
        new_y, new_x = y, x + 1
        # 범위를 넘으면 -> return
        if new_y < 0 or new_y >= N or new_x < 0 or new_x >= M:
            return
        if visited[new_y][new_x] and MAP[new_y][new_x] == s:
            visited[new_y][new_x] = False  # 방문 처리
            dfs(new_y, new_x, s)
    # 세로로만 움직이는 경우
    else:
        new_y, new_x = y + 1, x
        # 범위를 넘는다면 return
        if new_y < 0 or new_y >= N or new_x < 0 or new_x >= M:
            return
        if visited[new_y][new_x] and MAP[new_y][new_x] == s:
            visited[new_y][new_x] = False  # 방문 처리
            dfs(new_y, new_x, s)


visited = [[True] * M for _ in range(N)]
ans = 0
for y in range(N):
    for x in range(M):
        # 방문이 가능하다면 -> dfs 탐색
        if visited[y][x]:
            visited[y][x] = False  # 방문 처리
            dfs(y, x, MAP[y][x])  # dfs 탐색
            ans += 1
print(ans)
