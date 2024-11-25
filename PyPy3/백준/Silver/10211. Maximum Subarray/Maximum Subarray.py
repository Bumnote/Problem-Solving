from sys import stdin

input = stdin.readline

t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())
    lst = list(map(int, input().split()))

    SUM, MAX = lst[0], lst[0]
    for i in range(1, n):
        if SUM >= 0:
            SUM += lst[i]
            MAX = max(MAX, SUM)
        else:
            SUM = lst[i]
            MAX = max(MAX, SUM)

    print(MAX)
