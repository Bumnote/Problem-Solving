from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 4)
input = stdin.readline


def normal(cur_y, cur_x, color):
    dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        if 0 <= nxt_y < n and 0 <= nxt_x < n and canVisit[nxt_y][nxt_x] and MAP[nxt_y][nxt_x] == color:
            canVisit[nxt_y][nxt_x] = False  # 방문 처리
            normal(nxt_y, nxt_x, color)


def abnormal(cur_y, cur_x, color):
    dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        if 0 <= nxt_y < n and 0 <= nxt_x < n and canVisit[nxt_y][nxt_x]:
            # 적록색약인 경우 -> 빨강과 초록은 색을 구별하지 않는다.
            if (color == "R" or color == "G") and (MAP[nxt_y][nxt_x] == "R" or MAP[nxt_y][nxt_x] == "G"):
                canVisit[nxt_y][nxt_x] = False  # 방문 처리
                abnormal(nxt_y, nxt_x, color)
            elif MAP[nxt_y][nxt_x] == color:
                canVisit[nxt_y][nxt_x] = False  # 방문 처리
                abnormal(nxt_y, nxt_x, color)


n = int(input().rstrip())

MAP = [list(input().rstrip()) for _ in range(n)]
group_A, group_B = 0, 0
canVisit = [[True] * n for _ in range(n)]
# 정상인인 경우
for i in range(n):
    for j in range(n):
        if canVisit[i][j]:
            canVisit[i][j] = False  # 방문 처리
            group_A += 1
            normal(i, j, MAP[i][j])

# 적록색약인 경우
canVisit = [[True] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if canVisit[i][j]:
            canVisit[i][j] = False  # 방문 처리
            group_B += 1
            abnormal(i, j, MAP[i][j])

print(f"{group_A} {group_B}")
