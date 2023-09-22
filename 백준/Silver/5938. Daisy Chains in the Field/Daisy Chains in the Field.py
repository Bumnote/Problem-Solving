from sys import stdin

input = stdin.readline


def dfs(cur_v):
    for nxt_v in vertex[cur_v]:
        if visited[nxt_v]:
            visited[nxt_v] = False  # 방문 처리
            dfs(nxt_v)


n, m = map(int, input().split())
vertex = [[] for _ in range(n + 1)]

for _ in range(m):
    c1, c2 = map(int, input().split())
    vertex[c1].append(c2)
    vertex[c2].append(c1)

visited = [True] * (n + 1)
visited[1] = False  # 방문 처리
dfs(1)

flag = True
for i in range(1, n + 1):
    if visited[i]:
        flag = False
        print(i)

# 모든 노드가 1번 소에 연결되어 있는 경우 
if flag:
    print(0)
