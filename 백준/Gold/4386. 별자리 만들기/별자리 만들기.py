from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def get_dist(x1, y1, x2, y2):
    return ((x2 - x1) ** 2 + (y2 - y1) ** 2) ** 0.5


n = int(input().rstrip())  # n: 별의 개수
# 모든 간선에 대해서 따져야 하므로 -> 프림 알고리즘 활용 O(ElogV)
dic = {}
for i in range(1, n + 1):
    x, y = map(float, input().split())  # (x, y) 별의 좌표
    dic[i] = (x, y)

vertex = [[] for _ in range(n + 1)]  # n개의 정점 설정
for i in range(1, n + 1):
    cx, cy = dic[i]
    for j in range(1, n + 1):
        nx, ny = dic[j]
        # 자기 자신은 제외
        if cx == nx and cy == ny:
            continue
        dist = get_dist(cx, cy, nx, ny)
        vertex[i].append((j, dist))  # 해당 정점에서 (다음 정점, 거리) 저장

canVisit = [True for _ in range(n + 1)]
total = 0
cnt = 0
pq = [(0, 1)]  # 시작 정점을 1로 임의로 설정
while pq:
    cost, cur_v = heappop(pq)
    # 현재 노드를 이미 방문한 적이 있다면 -> continue
    if not canVisit[cur_v]:
        continue

    cnt += 1
    canVisit[cur_v] = False  # 방문 처리
    total += cost

    # 모든 정점을 방문했다면 -> break
    if cnt == n:
        break

    for nxt_v, dist in vertex[cur_v]:
        # 다음 노드로 방문이 가능하다면 -> push
        if canVisit[nxt_v]:
            # heappush로 현재 정점과 연결된 다음 정점으로 가는 가장 짧은 거리인 정점부터 선택하게 된다.
            heappush(pq, (dist, nxt_v))

print(f"{total:.2f}")
