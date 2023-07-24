from sys import stdin
from collections import deque

input = stdin.readline

n = int(input().strip())  # n: 우유 가게의 수
stores = list(map(int, input().split()))  # 가게 정보
deq = deque([0, 1, 2])
# 딸기(0) -> 초코(1) -> 바나나(2) -> 딸기 ...
cnt = 0
for milk in stores:
    if milk == deq[0]:
        cnt += 1
        deq.append(deq.popleft())

print(cnt)
