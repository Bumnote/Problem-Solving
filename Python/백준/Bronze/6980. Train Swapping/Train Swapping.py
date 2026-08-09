from sys import stdin

input = stdin.readline

t = int(input().rstrip())

for _ in range(t):
    l = int(input().rstrip())
    train = list(map(int, input().split()))

    cnt = 0

    for i in range(l):
        for j in range(l - i - 1):
            if train[j] > train[j + 1]:
                train[j], train[j + 1] = train[j + 1], train[j]
                cnt += 1

    print(f"Optimal train swapping takes {cnt} swaps.")
