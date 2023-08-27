from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize


# 다익스트라 알고리즘 구현
def dijkstra(s, e):
    dist = [INF] * (v + 1)
    dist[s] = 0
    pq = [(0, s)]

    while pq:
        min_dist, cur_v = heappop(pq)

        if dist[cur_v] != min_dist:
            continue

        for nxt_v, nxt_dist in vertex[cur_v].items():
            new_dist = dist[cur_v] + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    if e == 0:
        return dist
    else:
        return dist[e]


v, e = map(int, input().split())  # v: 정점의 개수, e: 도로의 개수
vertex = [{} for _ in range(v + 1)]

for _ in range(e):
    s, t, w = map(int, input().split())  # u <-> v:가중치 w 양방향
    # 간선이 존재하지 않는 경우 -> 새롭게 추가
    if t not in vertex[s]:
        vertex[s][t] = w
        vertex[t][s] = w
    # 간선이 이미 존재하는 경우 -> 거리 비교
    else:
        # 새로 입력된 간선의 가중치가 더 작다면 -> 새롭게 갱신
        if vertex[s][t] > w:
            vertex[s][t] = w
            vertex[t][s] = w

stores = [0] + list(map(int, input().split()))  # 야쿠르트 파는 10개 지점의 정점 번호
me = int(input().strip())  # 나의 출발 번호
my_d = dijkstra(me, 0)

start = 1
end = 2
total = 0
res = [(stores[start], stores[start], 0)]  # 시작점은 거리를 0으로 초기화
while start < 10 and end <= 10:
    d = dijkstra(stores[start], stores[end])
    # start -> end로 갈 수 없는 경우
    if d == INF:
        end += 1
    # start -> end로 갈 수 있는 경우
    else:
        total += d
        res.append((stores[start], stores[end], total))  # start -> end: total(걸리는 시간)
        start = end  # 도착점을 시작점으로 변경
        end += 1  # 도착점의 다음 정점을 새로운 도착점으로 변경

ans = INF
for s, e, t in res:
    # 야쿠르트 아줌마와 같거나 일찍 도착하면서, 정점의 수가 가장 작은 경우 -> 갱신
    if my_d[e] <= t and ans > e:
        ans = e

# 정점을 갱신하지 못하는 경우 -> 야쿠르트 아줌마보다 항상 늦는 경우 
print(ans if ans != INF else -1)
