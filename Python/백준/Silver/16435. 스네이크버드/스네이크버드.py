from sys import stdin

input = stdin.readline

n, l = map(int, input().split())
feeds = list(map(int, input().split()))

for feed in sorted(feeds):
    if feed <= l:
        l += 1

print(l)
