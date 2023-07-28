from sys import stdin
from collections import deque

input = stdin.readline


def isbinarygraph(x):
    deq = deque()
    deq.append((x, 1))
    visited[x] = False  # 방문 처리
    color = [0] * (V + 1)  # 1과 2로 색을 구별
    while deq:
        cur_x, cur_cnt = deq.popleft()

        # 현재 노드마다 색깔을 정해준다.
        if cur_cnt % 2 == 1:
            color[cur_x] = 1
        else:
            color[cur_x] = 2

        for nxt in vertex[cur_x]:
            if visited[nxt]:
                visited[nxt] = False  # 방문 처리
                deq.append((nxt, cur_cnt + 1))
            else:
                # 이미 방문한 곳이면서, 색깔이 다른 경우면 pass
                if color[cur_x] != color[nxt]:
                    pass
                # 이미 방문한 곳이면서, 색깔이 같은 경우면 -> 사이클 존재
                else:
                    return False
    return True


tc = int(input().strip())  # tc: 테스트 케이스

for _ in range(tc):
    V, E = map(int, input().split())
    vertex = [[] for _ in range(V + 1)]
    visited = [True] * (V + 1)

    for _ in range(E):
        u, v = map(int, input().split())
        vertex[u].append(v)
        vertex[v].append(u)

    # 어느 노드에서 시작하든, 사이클을 판단할 수 있다.
    flag = True
    # 비연결 그래프일 수 있으므로, 모든 노드를 기준으로 탐색
    for i in range(1, V + 1):
        if visited[i]:
            if isbinarygraph(i):
                continue
            else:
                flag = False
                break
        
    if flag:
        print("YES")
    else:
        print("NO")
