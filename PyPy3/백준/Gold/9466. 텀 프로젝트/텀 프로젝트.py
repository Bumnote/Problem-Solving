from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 5)
input = stdin.readline


def dfs(cur_x):
    global cnt

    for nxt_x in vertex[cur_x]:
        if visited[nxt_x]:
            if nxt_x in cycle:
                cnt -= len(cycle[cycle.index(nxt_x):])
            return

        else:
            visited[nxt_x] = True  # 방문 처리
            cycle.append(nxt_x)
            dfs(nxt_x)


t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())
    n_lst = list(map(int, input().split()))

    cnt = n
    vertex = [[] for _ in range(n + 1)]
    visited = [False for _ in range(n + 1)]
    for i in range(n):
        # 혼자 팀을 이루는 경우 -> 미리 방문 처리
        if n_lst[i] == i + 1:
            cnt -= 1
            visited[i + 1] = True  # 방문 처리
        vertex[i + 1].append(n_lst[i])  # i -> v 단방향

    for i in range(1, n + 1):
        if not visited[i]:
            visited[i] = True  # 방문 처리
            cycle = [i]
            dfs(i)

    print(cnt)
