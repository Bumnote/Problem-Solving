from sys import stdin
from collections import deque

input = stdin.readline

n, m = map(int, input().split())  # n: 사다리의 수, m: 뱀의 수

ladder = dict()
for _ in range(n):
    x, y = map(int, input().split())
    ladder[x] = y  # x칸 -> y칸

snake = dict()
for _ in range(m):
    u, v = map(int, input().split())
    snake[u] = v  # u칸 -> v칸

canVisit = [True for _ in range(101)]
canVisit[1] = False  # 시작점 방문 처리
dq = deque([(1, 0)])

while dq:

    cur_v, cnt = dq.popleft()
    if cur_v == 100:
        print(cnt)
        break

    for dist in range(1, 7):
        nxt_v = cur_v + dist
        # 범위를 넘지않고, 방문 가능하다면 -> 탐색
        if 1 <= nxt_v <= 100 and canVisit[nxt_v]:
            canVisit[nxt_v] = False  # 방문 처리
            # 사다리가 존재하고, 사다리로 이동한 곳이 방문했던 곳이라도 -> append
            if nxt_v in ladder:
                canVisit[nxt_v] = False  # 방문 처리
                dq.append((ladder[nxt_v], cnt + 1))
            # 뱀이 존재하고, 뱀을 타고 이동한 곳이 방문했던 곳이라도 -> append
            elif nxt_v in snake:
                canVisit[nxt_v] = False  # 방문 처리
                dq.append((snake[nxt_v], cnt + 1))
            # 사다리와 뱀이 존재하지 않고, 방문 가능한 곳이면 -> append
            else:
                dq.append((nxt_v, cnt + 1))
