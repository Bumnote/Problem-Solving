from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
tc = int(input().strip())  # 테스트 케이스


def bfs(x):
    deq = deque()
    deq.append((x, 0))
    visited = [True] * (v + 1)
    visited[x] = False  # 방문 처리
    cnt = -1

    while deq:
        cur_x, cur_cnt = deq.popleft()
        if cur_cnt <= 2:
            cnt += 1
        else:
            break

        for next in vertex[cur_x]:
            # 방문이 가능하다면 -> append
            if visited[next]:
                visited[next] = False  # 방문 처리
                deq.append((next, cur_cnt + 1))

    return cnt


for _ in range(tc):
    temp = list(input().split())
    v, e = map(int, temp[:2])  # v: 노드의 개수, e: 간선의 개수
    vx = int(temp[-1][-1])  # 홉 수를 세는 기준 노드
    vertex = [[] for _ in range(v + 1)]

    for i in range(2, 2 + e * 2, 2):
        v1, v2 = int(temp[i][1]), int(temp[i + 1][1])
        vertex[v1].append(v2)
        vertex[v2].append(v1)

    ## 문제 해결 부분 ##
    res = bfs(vx)
    print(f"The number of supervillains in 2-hop neighborhood of v{vx} is {res}")
