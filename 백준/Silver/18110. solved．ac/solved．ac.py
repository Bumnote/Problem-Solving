from sys import stdin

input = stdin.readline

n = int(input().rstrip())
lst = sorted([int(input().rstrip()) for _ in range(n)])

# 아직 아무 의견이 없다면 -> 난이도 0
if n == 0:
    print(0)
else:
    limit = int((n * 0.15) + 0.5)

    lst = lst[limit: n - limit]  # 절사된 난이도 의견
    n = n - limit * 2  # 절사된 인원

    avg = int((sum(lst) / n) + 0.5)
    print(f"{avg}")
