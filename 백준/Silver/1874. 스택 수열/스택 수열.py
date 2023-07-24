from sys import stdin

input = stdin.readline

n = int(input().strip())  # n개의 숫자
ans = [int(input().strip()) for _ in range(n)]
res = []
temp = []
cond = []

s = 0
for i in range(1, n + 1):
    temp.append(i)
    cond.append("+")

    # temp의 값이 존재하고, 마지막 값과 ans값이 같다면 -> pop
    while temp and ans[s] == temp[-1]:
        res.append(temp.pop())
        cond.append("-")
        s += 1

if temp:
    print("NO")
else:
    print(*cond, sep="\n")
