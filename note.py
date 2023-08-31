from sys import stdin

input = stdin.readline

n = int(input().strip())
ans_1 = 0
for i in range(1, n + 1):
    ans_1 += i

print(f"{ans_1}\n{ans_1 ** 2}\n{ans_1 ** 2}")
