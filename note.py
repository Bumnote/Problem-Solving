from sys import stdin, setrecursionlimit

setrecursionlimit(10_000)
input = stdin.readline

N, M = map(int, input().split())  # N x M MAP
MAP = [list(map(int, input().split())) for _ in range(N)]
visited = [[True] * M for _ in range(N)]
visited[0][0] = False  # 출발점 방문 표시
cnt = 0


def dfs(y, x):
    global cnt

    if y == N - 1 and x == M - 1:
        cnt += 1

    for dy, dx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
        new_y, new_x = y + dy, x + dx
        # 범위를 넘는 경우 -> 탐색하지 않는다.
        if new_y < 0 or new_y >= N or new_x < 0 or new_x >= M:
            continue
        # 방문 가능하고, 현재 위치보다 낮은 지역이라면 -> 탐색을 시도한다.
        if visited[new_y][new_x] and MAP[y][x] > MAP[new_y][new_x]:
            visited[new_y][new_x] = False  # 방문 표시
            dfs(new_y, new_x)
            visited[new_y][new_x] = True  # 복원 표시


dfs(0, 0)
print(cnt)
