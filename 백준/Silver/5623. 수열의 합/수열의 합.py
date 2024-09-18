from sys import stdin

input = stdin.readline

n = int(input().rstrip())

lst = [list(map(int, input().split())) for _ in range(n)]

if n == 2:
    print(f"{1} {lst[0][1] - 1}")

else:
    a0 = (lst[0][1] + lst[0][2] - lst[1][2]) // 2
    ans = [a0]
    for i in range(1, n):
        ans.append(lst[0][i] - a0)

    print(*ans)
