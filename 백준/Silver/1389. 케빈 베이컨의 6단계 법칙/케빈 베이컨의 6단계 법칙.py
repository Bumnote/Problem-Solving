from sys import stdin
from collections import deque  # 너비 우선 탐색

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # (2 <= n <= 100): 유저의 수, (1<= m <= 5,000): 친구 관계의 수

## 문제 해결 부분 ##
user = [[] for _ in range(n + 1)]  # 유저들의 관계 -> 인접 리스트로 표현
visited = [True] * (n + 1)  # 방문 확인
# print(user)
for _ in range(m):
    u1, u2 = map(int, input().split())
    #print(f"u1 = {u1} / u2 = {u2}")
    user[u1].append(u2)  # 서로 연결되는 유저들의 관계를 추가
    user[u2].append(u1)  # 서로 연결되는 유저들의 관계를 추가

kevin_num = 5001  # 최솟값을 찾으므로, 나올 수 있는 최댓값으로 설정
user_num = 0


def bfs(i, j):
    """
    너비 우선 탐색 구현 -> 유저들간의 최소 거리
    """
    visited = [True] * (n + 1)  # 방문 확인
    visited[i] = False  # 방문 처리
    deq = deque()
    deq.append((i, 0))  # (현재 유저, 관계 수)

    while deq:

        cur_u, cur_cnt = deq.popleft()
        if cur_u == j:
            return cur_cnt

        for next_u in user[cur_u]:
            # 방문 가능하면 -> deq에 추가
            if visited[next_u]:
                visited[next_u] = False # 방문 처리
                deq.append((next_u, cur_cnt + 1))


for i in range(1, n + 1):
    cnt = 0  # i번 user의 케빈 베이컨 수
    for j in range(1, n + 1):
        cnt += bfs(i, j)  # 사람과 사람 사이의 최소 거리를 알아야 하므로 너비 우선 탐색!

    # 1번 유저부터 순서대로 최솟값을 체크하므로, 여러 명일 경우 번호가 작은 사람을 출력한다.
    if kevin_num > cnt:
        kevin_num = cnt  # 케빈 베이컨의 숫자가 가장 늦을 때마다 갱신
        user_num = i  # 유저의 번호도 갱신 -> 정답 변수가 된다.

print(user_num)  # 정답 출력
