from sys import stdin, maxsize
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n: 회원의 수 (n <= 50)
vertex = [[] for _ in range(n + 1)]

while True:
    v1, v2 = map(int, input().split())  # v1 <-> v2: 양방향 그래프
    if v1 == -1 and v2 == -1:
        break

    vertex[v1].append(v2)
    vertex[v2].append(v1)


def bfs(x):
    deq = deque()
    deq.append((x, 0))
    visited = [True] * (n + 1)
    visited[x] = False  # 방문 처리

    while deq:
        cur_x, cur_cnt = deq.popleft()

        for next in vertex[cur_x]:
            # 방문이 가능하다면 -> append()
            if visited[next]:
                visited[next] = False  # 방문 처리
                deq.append((next, cur_cnt + 1))

    return cur_cnt


president = maxsize
lst = []
for i in range(1, n + 1):
    cnt = bfs(i)
    # 점수가 더 적다면 -> 배열 재선언 및 값 초기화
    if cnt < president:
        president = cnt
        lst = [i]
    # 점수가 같다면 -> 후보순위 등극
    elif cnt == president:
        lst.append(i)

print(f"{president} {len(lst)}")
print(*lst)
