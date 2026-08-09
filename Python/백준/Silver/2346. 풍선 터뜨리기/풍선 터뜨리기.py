from collections import deque
from sys import stdin

input = stdin.readline

n = int(input().rstrip())
dq = deque(map(int, input().split()))
idx = deque([i for i in range(1, n + 1)])

ans = []
while True:
  rotation = dq.popleft()
  ans.append(idx.popleft())

  if not dq:
    break
  if rotation >= 0:
    for _ in range(rotation - 1):
      dq.append(dq.popleft())
      idx.append(idx.popleft())
  else:
    rotation = -rotation
    for _ in range(rotation):
      dq.appendleft(dq.pop())
      idx.appendleft(idx.pop())

print(*ans)
