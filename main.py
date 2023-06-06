from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n: 상근이의 동기 수
m = int(input().strip())  # m: 친구 관계 수
vertex = [[] for _ in range(n + 1)]  # 동기들의 관계 표현
visited = [True for _ in range(n + 1)]  # 방문 확인용 리스트

for _ in range(m):
    v1, v2 = map(int, input().split())
    # 양방향 그래프 구현
    vertex[v1].append(v2)
    vertex[v2].append(v1)


## 문제 해결 부분 ##
def bfs(x):
    deq = deque()
    deq.append((x, 0))
    visited[x] = False  # 상근이 방문 처리
    person_cnt = -1  # 초대할 사람의 수 -> while문 들어가서 +1 되므로 -1로 선언

    while deq:
        cur_num, cur_cnt = deq.popleft()  # (현재 친구 번호, 관계 거리)
        if cur_cnt <= 2:
            person_cnt += 1
        # 관계 거리가 2보다 커지면 더 이상 조사할 필요가 없으므로, break
        else:
            break

        for elem in vertex[cur_num]:
            # 방문이 가능하다면 -> deq에 추가
            if visited[elem]:
                visited[elem] = False  # 방문 처리
                deq.append((elem, cur_cnt + 1))

    return person_cnt


print(bfs(1))  # 상근이부터 시작 -> 친구의 친구까지 허용 = 거리 2
