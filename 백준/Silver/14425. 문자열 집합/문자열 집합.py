from sys import stdin

input = stdin.readline

n, m = map(int, input().split())
s = set()
for _ in range(n):
    st = input().strip()
    s.add(st)

cnt = 0
for _ in range(m):
    st = input().strip()
    if st in s:
        cnt += 1

print(cnt)
