from sys import stdin

input = stdin.readline


def dfs(y, x, s):
    global cnt, visited

    # 목적지에 도착했다면 -> cnt 1 증가 후 return
    if y == n - 1 and x == n - 1:
        cnt += 1
        return

    # 현재 상태가 가로 상태인 경우
    if s == 1:
        # 오른쪽으로 갈 수 있고, 방문 가능하다면 -> 가로로 이동
        if x + 1 < n and MAP[y][x + 1] == 0 and visited[y][x + 1]:
            visited[y][x + 1] = False  # 방문 처리
            dfs(y, x + 1, 1)
            visited[y][x + 1] = True  # 복원 처리

        # 대각선으로 이동가능하고, 방문 가능하다면 -> 대각선으로 이동
        if x + 1 < n and y + 1 < n and MAP[y][x + 1] == 0 and MAP[y + 1][x + 1] == 0 and MAP[y + 1][x] == 0:
            if visited[y][x + 1] and visited[y + 1][x + 1] and visited[y + 1][x]:
                visited[y + 1][x + 1] = False  # 방문 처리
                dfs(y + 1, x + 1, 2)
                visited[y + 1][x + 1] = True  # 복원 처리

    # 현재 상태가 대각선 상태인 경우
    elif s == 2:
        # 오른쪽으로 갈 수 있고, 방문 가능하다면 -> 가로로 이동
        if x + 1 < n and MAP[y][x + 1] == 0 and visited[y][x + 1]:
            visited[y][x + 1] = False  # 방문 처리
            dfs(y, x + 1, 1)
            visited[y][x + 1] = True  # 복원 처리

        # 대각선으로 이동가능하고, 방문 가능하다면 -> 대각선으로 이동
        if x + 1 < n and y + 1 < n and MAP[y][x + 1] == 0 and MAP[y + 1][x + 1] == 0 and MAP[y + 1][x] == 0:
            if visited[y][x + 1] and visited[y + 1][x + 1] and visited[y + 1][x]:
                visited[y + 1][x + 1] = False  # 방문 처리
                dfs(y + 1, x + 1, 2)
                visited[y + 1][x + 1] = True  # 복원 처리

        # 세로로 갈 수 있고, 방문 가능하다면 -> 세로로 이동
        if y + 1 < n and MAP[y + 1][x] == 0 and visited[y + 1][x]:
            visited[y + 1][x] == False  # 방문 처리
            dfs(y + 1, x, 3)
            visited[y + 1][x] == True  # 복원 처리

    # 현재 상태가 세로 상태인 경우
    else:
        # 대각선으로 이동가능하고, 방문 가능하다면 -> 대각선으로 이동
        if x + 1 < n and y + 1 < n and MAP[y][x + 1] == 0 and MAP[y + 1][x + 1] == 0 and MAP[y + 1][x] == 0:
            if visited[y][x + 1] and visited[y + 1][x + 1] and visited[y + 1][x]:
                visited[y + 1][x + 1] = False  # 방문 처리
                dfs(y + 1, x + 1, 2)
                visited[y + 1][x + 1] = True  # 복원 처리

        # 세로로 갈 수 있고, 방문 가능하다면 -> 세로로 이동
        if y + 1 < n and MAP[y + 1][x] == 0 and visited[y + 1][x]:
            visited[y + 1][x] == False  # 방문 처리
            dfs(y + 1, x, 3)
            visited[y + 1][x] == True  # 복원 처리


n = int(input().strip())  # n: 집의 크기 n x n
MAP = [list(map(int, input().split())) for _ in range(n)]

# 1: 가로, 2: 대각선, 3: 세로
cnt = 0
visited = [[True] * n for _ in range(n)]
visited[0][0], visited[0][1] = False, False  # 최초의 상태 -> 방문 표시

# 도착지에 접근이 불가능한 경우 -> pass 
if MAP[n - 1][n - 1] == 1:
    pass
# 도착지에 접근이 가능한 경우 -> dfs 탐색
else:
    dfs(0, 1, 1)

print(cnt)
