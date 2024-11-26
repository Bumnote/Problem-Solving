from sys import stdin

input = stdin.readline

n = int(input())
lst = [float(input().rstrip()) for _ in range(n)]

for i in range(1, n):
    lst[i] = max(lst[i], lst[i] * lst[i - 1])

print('%0.3f' % max(lst))
