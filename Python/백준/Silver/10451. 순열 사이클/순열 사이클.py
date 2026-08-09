from sys import stdin

input = stdin.readline


def dfs(cur_v):
    for nxt_v in vertex[cur_v]:
        if not visited[nxt_v]:
            visited[nxt_v] = True
            dfs(nxt_v)


t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())  # n: 순열의 크기
    lst = list(map(int, input().split()))

    vertex = [[] for _ in range(n + 1)]

    for s, e in enumerate(lst, start=1):
        vertex[s].append(e)  # s -> e

    cnt = 0
    visited = [False for _ in range(n + 1)]
    for i in range(1, n + 1):
        if not visited[i]:
            visited[i] = True  # 방문 처리
            dfs(i)
            cnt += 1

    print(cnt)
