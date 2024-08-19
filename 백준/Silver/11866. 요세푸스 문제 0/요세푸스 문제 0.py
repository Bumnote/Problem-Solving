from sys import stdin
from collections import deque

input = stdin.readline

n, k = map(int, input().split())

lst = deque([i for i in range(1, n + 1)])
order = []

while lst:

    for _ in range(k - 1):
        lst.append(lst.popleft())

    order.append(lst.popleft())

print(f"<", end="")
print(*order, sep=', ', end="")
print(f">")
