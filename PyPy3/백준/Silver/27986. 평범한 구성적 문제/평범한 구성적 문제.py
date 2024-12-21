from sys import stdin

input = stdin.readline

n, m = map(int, input().split())

k = float('inf')
for _ in range(m):
    l, r = map(int, input().split())
    k = min(k, r - l + 1)

lst = []
for i in range(1, n + 1):
    lst.append(k if i % k == 0 else i % k)

print(*lst)
