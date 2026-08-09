from sys import stdin

input = stdin.readline

LEN = 1_001

n = int(input().rstrip())  # n: 교통편의 개수
cost = None
lst = [0 for _ in range(LEN + 1)]
for _ in range(n):
    d, c = input().split()
    lst[min(1001, int(c))] += 1

    if d == "jinju":
        cost = int(c)

cnt = 0
for num in range(cost + 1, LEN + 1):
    cnt += lst[num]

print(cost)
print(cnt)
