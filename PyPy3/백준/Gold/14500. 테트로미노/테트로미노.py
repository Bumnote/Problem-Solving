from sys import stdin

input = stdin.readline


# 뻐큐 모양 탐색
def check(cur_y, cur_x, value):
    global MAX

    is_true_value = []
    # 현재 값을 기준으로 사방 탐색
    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        # 범위를 넘지 않는다면 -> 탐색
        if 0 <= nxt_y < n and 0 <= nxt_x < m:
            is_true_value.append(MAP[nxt_y][nxt_x])

    # 정사각형이 4개가 가능하면 -> 가장 작은 값들의 합으로 MAX 갱신
    if len(is_true_value) >= 3:
        MAX = max(MAX, value + sum(sorted(is_true_value, reverse=True)[:3]))

    return


def dfs(cur_y, cur_x, cnt, total):
    global MAX

    # 4개의 정사각형이 모이면 -> 최댓값 갱신
    if cnt == 4:
        MAX = max(MAX, total)
        return

    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        # 범위를 넘지않고, 방문이 가능하다면
        if 0 <= nxt_y < n and 0 <= nxt_x < m and canVisit[nxt_y][nxt_x]:
            canVisit[nxt_y][nxt_x] = False  # 방문 처리
            dfs(nxt_y, nxt_x, cnt + 1, total + MAP[nxt_y][nxt_x])
            canVisit[nxt_y][nxt_x] = True  # 복구 처리


n, m = map(int, input().split())  # n x m MAP
MAP = [list(map(int, input().split())) for _ in range(n)]
canVisit = [[True for _ in range(m)] for _ in range(n)]

dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
MAX = 0

for y in range(n):
    for x in range(m):
        canVisit[y][x] = False  # 방문 처리
        dfs(y, x, 1, MAP[y][x])  # 뻐큐 모양을 제외한 나머지 dfs 완전 탐색
        canVisit[y][x] = True  # 복구 처리

        check(y, x, MAP[y][x])

print(MAX)
