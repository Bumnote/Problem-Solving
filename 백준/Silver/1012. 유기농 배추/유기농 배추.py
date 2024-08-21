from sys import stdin, setrecursionlimit

setrecursionlimit(2_500)
input = stdin.readline


def dfs(cur_y, cur_x):
    canVisit[cur_y][cur_x] = False  # 현재 위치 방문 처리

    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        # 범위를 넘지 않고, 방문이 가능하다면 -> 재귀적 dfs 탐색 
        if 0 <= nxt_y < n and 0 <= nxt_x < m and canVisit[nxt_y][nxt_x]:
            dfs(nxt_y, nxt_x)


t = int(input().rstrip())

for _ in range(t):
    m, n, k = map(int, input().split())  # m: 가로, n: 세로, k: 배추의 개수
    MAP = [[0] * m for _ in range(n)]  # 배추 정보 리스트
    canVisit = [[False] * m for _ in range(n)]
    for _ in range(k):
        x, y = map(int, input().split())
        MAP[y][x] = 1  # 배추의 위치 저장
        canVisit[y][x] = True

    cnt = 0
    dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
    for i in range(n):
        for j in range(m):
            # 방문이 가능하다면 -> dfs 탐색
            if canVisit[i][j]:
                dfs(i, j)
                cnt += 1

    print(cnt)
