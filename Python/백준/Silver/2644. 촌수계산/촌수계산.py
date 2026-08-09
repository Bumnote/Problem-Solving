from sys import stdin

input = stdin.readline


def dfs(cur_x, target, cnt):
    global rel

    if cur_x == target:
        rel = cnt
        return

    for nxt_x in vertex[cur_x]:
        if canVisit[nxt_x]:
            canVisit[nxt_x] = False
            dfs(nxt_x, target, cnt + 1)


n = int(input().rstrip())
a, b = map(int, input().split())
m = int(input().rstrip())

vertex = [[] for _ in range(n + 1)]
canVisit = [True for _ in range(n + 1)]

rel = -1
for _ in range(m):
    x, y = map(int, input().split())  # x: 부모, y: 자식
    vertex[x].append(y)
    vertex[y].append(x)

dfs(a, b, 0)

print(rel)
