from sys import stdin

input = stdin.readline


def dfs(s, e, d):
    global dist

    if s == e:
        dist = d
        return

    for nxt_v, nxt_dist in vertex[s]:
        # 방문이 가능하다면 -> 깊이 우선 탐색
        if visited[nxt_v]:
            visited[nxt_v] = False  # 방문 처리
            dfs(nxt_v, e, d + nxt_dist)


n, m = map(int, input().split())  # n: 노드의 개수, m: 거리를 알고 싶은 노드 쌍의 개수
vertex = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    v1, v2, d = map(int, input().split())  # v1 <-> v2: 거리 d 양방향
    vertex[v1].append((v2, d))
    vertex[v2].append((v1, d))

for _ in range(m):
    a, b = map(int, input().split())  # a <-> b: 거리를 구하자
    visited = [True] * (n + 1)
    visited[a] = False  # 방문 표시
    dist = 0
    dfs(a, b, 0)

    print(dist)
