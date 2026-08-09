from sys import stdin

input = stdin.readline

n, k, p = map(int, input().split())
lst = list(map(int, input().split()))

cnt = 0
for i in range(0, n * k, k):
    none = 0
    for j in range(i, i + k):
        if lst[j] == 0:
            none += 1

    if none < p:
        cnt += 1

print(cnt)
