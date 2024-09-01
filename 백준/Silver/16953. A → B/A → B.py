from sys import stdin
from collections import deque

input = stdin.readline

a, b = map(int, input().split())
dq = deque([(a, 0)])
ans = 0
flag = False
while dq:

    cur_v, cnt = dq.popleft()

    if cur_v == b:
        ans = cnt + 1
        flag = True
        break

    for nxt_v in [cur_v * 2, 1 + cur_v * 10]:
        # 범위를 넘지 않고, b 이하인 수들에 대해서만 탐색
        if a <= nxt_v <= b and nxt_v <= b:
            dq.append((nxt_v, cnt + 1))

print(ans if flag else -1)
