from sys import stdin

input = stdin.readline

A = list(map(int, input().rstrip()))
B = list(map(int, input().rstrip()))

LEN = 16
lst = [[0, 0] for _ in range(LEN)]

for i in range(0, LEN, 2):
    lst[i][0] = A[i // 2]
    lst[i + 1][0] = B[i // 2]

for i in range(1, LEN):
    for j in range(i, LEN):
        lst[j][1] = (lst[j - 1][0] + lst[j][0]) % 10

    if i == LEN - 1:
        break
    for k in range(i, LEN):
        lst[k][0] = lst[k][1]

print(f"{lst[LEN - 2][0]}{lst[LEN - 1][0]}")
