from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n: 사람의 수 (n <= 50)
graph = [list(input().strip()) for _ in range(n)]  # 친구 관계


## 문제 해결 부분 ##
def bfs(x):
    global cnt
    deq = deque()
    visited = [True] * n
    deq.append((x, 0))
    visited[x] = False  # 방문 처리

    while deq:
        cur_x, cur_cnt = deq.popleft()
        if cur_cnt <= 2:
            cnt += 1
        else:
            return

        for i, next in enumerate(graph[cur_x]):
            # 방문 가능하고, "Y"라면 -> append
            if visited[i] and next == "Y":
                visited[i] = False  # 방문 처리
                deq.append((i, cur_cnt + 1))


ans = 0
for i in range(n):
    cnt = -1
    bfs(i)
    ans = max(ans, cnt)

print(ans)
