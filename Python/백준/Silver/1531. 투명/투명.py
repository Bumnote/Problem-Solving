from sys import stdin

input = stdin.readline


def set_paper(y1, x1, y2, x2):
    for y in range(y1, y2 + 1):
        for x in range(x1, x2 + 1):
            MAP[y][x] += 1


n, m = map(int, input().split())
MAP = [[0 for _ in range(101)] for _ in range(101)]
points = [list(map(int, input().split())) for _ in range(n)]
for point in points:
    y1, x1, y2, x2 = point
    set_paper(y1, x1, y2, x2)

cnt = 0
for y in range(1, 101):
    for x in range(1, 101):
        if MAP[y][x] > m:
            cnt += 1

print(cnt)
