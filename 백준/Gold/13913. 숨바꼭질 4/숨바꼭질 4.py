from sys import stdin
from collections import deque

input = stdin.readline

N, K = map(int, input().split())  # N: 수빈의 위치, K: 동생의 위치

visited = [-1] * 100_001


def bfs(N, K):
    dq = deque()
    dq.append((N, 0))
    visited[N] = "*"  # 방문 처리
    ans = deque()  # 경로를 담을 덱 
    while dq:
        cur_x, cur_cnt = dq.popleft()

        # 수빈이와 동생이 만났다면 -> 이동 경로 출력
        if cur_x == K:
            print(cur_cnt)  # 최소 이동 시간 출력
            while True:
                ans.appendleft(cur_x)  # 역순으로 출력하기 위해서 왼쪽부터 append
                # 시작 위치인 N에 도착하면 -> 경로 출력 후 return 
                if visited[cur_x] == "*":
                    print(*ans)
                    return

                cur_x = visited[cur_x]  # 역순으로 탐색하면서 이전 값으로 갱신

        for nxt in (cur_x - 1, cur_x + 1, cur_x * 2):
            # 범위를 넘지 않고, 방문한 적이 없다면 -> 수빈이가 이동 가능
            if 0 <= nxt <= 100_000 and visited[nxt] == -1:
                visited[nxt] = cur_x  # 다음 이동할 위치에 현재 위치를 저장한다.
                dq.append((nxt, cur_cnt + 1))


bfs(N, K)
