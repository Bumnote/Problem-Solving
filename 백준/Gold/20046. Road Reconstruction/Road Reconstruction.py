from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

INF = float('inf')
r, c = map(int, input().split())  # r x c 격자
# 0: 도로 유실이 없는 상태, 1: 1의 건설 비용, 2: 2의 건설 비용, -1: 건설할 수 없는 곳
grid = [list(map(int, input().split())) for _ in range(r)]
dist = [[INF] * c for _ in range(r)]  # 2차원 거리 배열
dist[0][0] = grid[0][0]  # 시작위치의 거리를 출발점의 거리로 초기화
pq = [(dist[0][0], 0, 0)]  # (거리, y, x)

while pq:
    min_dist, cur_y, cur_x = heappop(pq)

    # 현재 위치까지 최단거리 정보와 주어진 정보가 일치하지 않는다면 -> continue
    if min_dist != dist[cur_y][cur_x] or dist[cur_y][cur_x] == -1:
        continue

    for dy, dx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
        new_y, new_x = cur_y + dy, cur_x + dx
        # 새로운 위치가 범위를 넘거나, 건설할 수 없는 곳이라면 -> continue
        if new_y < 0 or new_y >= r or new_x < 0 or new_x >= c or grid[new_y][new_x] == -1:
            continue
        new_dist = dist[cur_y][cur_x] + grid[new_y][new_x]  # 현재 노드에서 다음 노드로 가는 거리
        # 현재 노드에서 다음 노드로 가는 거리가 더 짧다면 -> 갱신
        if new_dist < dist[new_y][new_x]:
            dist[new_y][new_x] = new_dist
            heappush(pq, (new_dist, new_y, new_x))

print(dist[r - 1][c - 1] if dist[r - 1][c - 1] != INF else -1)
