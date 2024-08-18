from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 5)
input = stdin.readline


def dfs(cur_v):
    global cnt

    canVisit[cur_v] = cnt
    for nxt_v in vertex[cur_v]:
        if canVisit[nxt_v] == 0:
            canVisit[nxt_v] = cnt + 1  # 방문 처리
            cnt += 1
            dfs(nxt_v)


n, m, r = map(int, input().split())

vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    u, v = map(int, input().split())
    vertex[u].append(v)
    vertex[v].append(u)

for i in range(1, n + 1):
    vertex[i].sort(reverse=True)

canVisit = [0 for _ in range(n + 1)]
cnt = 1
dfs(r)

print(*canVisit[1:], sep='\n')
