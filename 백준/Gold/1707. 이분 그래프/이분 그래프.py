from sys import stdin, setrecursionlimit

setrecursionlimit(2 * (10 ** 4))

input = stdin.readline


def isbinarygraph(x, cnt):
    global flag
    visited[x] = False  # 현재 노드 방문 처리

    color[x] = 1 if cnt % 2 == 1 else 0

    for nxt in vertex[x]:
        # 다음 노드로 방문이 가능하다면 -> 깊이 탐색 ㄴ
        if visited[nxt]:
            isbinarygraph(nxt, cnt + 1)
        # 이미 방문했던 노드라면 -> 색깔 확인
        else:
            # 방문했던 인접 노드와 색깔이 같다면 -> 이분 그래프 X
            if color[x] == color[nxt]:
                flag = False
                return


tc = int(input().strip())  # tc: 테스트 케이스

for _ in range(tc):
    V, E = map(int, input().split())
    vertex = [[] for _ in range(V + 1)]
    visited = [True] * (V + 1)
    color = [0] * (V + 1)

    for _ in range(E):
        u, v = map(int, input().split())
        vertex[u].append(v)
        vertex[v].append(u)

    # 어느 노드에서 시작하든, 사이클을 판단할 수 있다.
    flag = True
    # 비연결 그래프일 수 있으므로, 모든 노드를 기준으로 탐색
    for i in range(1, V + 1):
        if visited[i]:
            isbinarygraph(i, 1)

    if flag:
        print("YES")
    else:
        print("NO")
