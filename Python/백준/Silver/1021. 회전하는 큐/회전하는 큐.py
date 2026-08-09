from sys import stdin
from collections import deque

input = stdin.readline

n, m = map(int, input().split())
lst = deque(map(int, input().split()))

dq = deque()
nums = deque([i for i in range(1, n + 1)])

cnt = 0
while lst:
    target = lst.popleft()
    idx = nums.index(target)
    if idx == 0:
        nums.popleft()
    else:
        if len(nums) - idx >= idx:
            for _ in range(idx):
                nums.append(nums.popleft())
                cnt += 1
            nums.popleft()
        else:
            for _ in range(len(nums) - idx):
                nums.appendleft(nums.pop())
                cnt += 1
            nums.popleft()

print(cnt)
