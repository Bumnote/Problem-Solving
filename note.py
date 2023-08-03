from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 5)
input = stdin.readline
result = 0


def dfs(root, cnt):
    global result
    if v_list[root] == k:
        result = cnt

    for nxt in vertex[root]:
        dfs(nxt, cnt + 1)


n, k = map(int, input().split())  # n: 정점의 수, k: 목표 노드 번호
vertex = [[] for i in range(n)]
for i in range(n - 1):
    p, c = map(int, input().split())  # p -> c: 단방향 그래프
    vertex[p].append(c)

v_list = list(map(int, input().split()))

dfs(0, 0)
print(result)
