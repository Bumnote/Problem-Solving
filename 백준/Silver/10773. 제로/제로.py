from sys import stdin

input = stdin.readline

k = int(input().rstrip())
stk = []

for _ in range(k):
    num = int(input().rstrip())
    if num != 0:
        stk.append(num)
    else:
        stk.pop()

print(sum(stk))
