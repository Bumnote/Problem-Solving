from sys import stdin

input = stdin.readline


def can_go(y, x):
    # 해당 알파벳이 존재하지 않으면 -> 이동 가능
    if MAP[y][x] not in dic:
        return True
    # 해당 알파벳이 이미 존재하면 -> 이동 불가능
    else:
        return False


def dfs(y, x, cnt):
    global ans
    ans = max(ans, cnt)

    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = y + dy, x + dx
        # 범위를 넘지 않고, 방문이 가능하며, 해당 알파벳이 처음이라면 -> dfs
        if 0 <= nxt_y < r and 0 <= nxt_x < c and canVisit[nxt_y][nxt_x] and can_go(nxt_y, nxt_x):
            canVisit[nxt_y][nxt_x] = False  # 방문 처리
            dic.add(MAP[nxt_y][nxt_x])  # 다음 알파벳 저장
            dfs(nxt_y, nxt_x, cnt + 1)
            canVisit[nxt_y][nxt_x] = True  # 복구 처리
            dic.discard(MAP[nxt_y][nxt_x])  # 다음 알파벳 제거


r, c = map(int, input().split())  # r x c MAP
MAP = [list(input().rstrip()) for _ in range(r)]
canVisit = [[True for _ in range(c)] for _ in range(r)]
canVisit[0][0] = False  # 시작점 방문 처리

# 좌측 상단에서 시작 -> start (0, 0)
ans = 0
dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
dic = set(MAP[0][0])
dfs(0, 0, 1)

print(ans)
