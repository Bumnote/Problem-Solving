from sys import stdin

input = stdin.readline

t = int(input().rstrip())
for _ in range(t):
    n = int(input().rstrip())
    lst = list(map(int, input().split()))

    total, curr, idx = 0, 0, 0
    while curr != n:
        if curr + lst[idx] > n:
            idx += 1
            if idx == 6:
                idx = 0
            continue

        curr += lst[idx]
        total += curr
        idx += 1
        if idx == 6:
            idx = 0

    print(total)
