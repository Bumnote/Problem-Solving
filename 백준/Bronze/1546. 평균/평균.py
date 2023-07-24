from sys import stdin

input = stdin.readline

n = int(input().strip())
n_list = list(map(int, input().split()))
M = max(n_list)

SUM = 0
for i in range(n):
    SUM += (n_list[i] / M * 100)

print(f"{SUM / n}")
