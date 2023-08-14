from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize

T = int(input().strip())  # T: 테스트 케이스

for _ in range(T):
    k, w, h = map(int, input().split())  # k: 클래스 개수, w: 평면의 폭, h: 평면의 높이
    MAP = []
    alpha = [0] * 26
    for _ in range(k):
        # 클래스 이름은 "E" 가 될 수 없다.
        c_name, t = input().split()  # c_name: 클래스 이름, t: 시간
        alpha[ord(c_name) - 65] = int(t)

    y, x = 0, 0
    for i in range(h):
        MAP.append(list(input().strip()))
        for j in range(w):
            # 엔터프라이즈호의 위치를 저장 -> 거리는 dist 배열에서 정의하므로 continue
            if MAP[i][j] == "E":
                y, x = i, j
                continue
            MAP[i][j] = alpha[ord(MAP[i][j]) - 65]  # 클래스에 해당하는 무력화 시간을 저장

    dist = [[INF] * w for _ in range(h)]
    dist[y][x] = 0
    pq = [(0, y, x)]
    ans = INF

    # 우선순위 큐를 활용하여 다익스트라 알고리즘을 구현
    while pq:
        min_dist, cur_y, cur_x = heappop(pq)

        if dist[cur_y][cur_x] != min_dist:
            continue

        # 현재 위치가 가장 자리인 경우 -> 최단 시간으로 계속 갱신해주도록 한다.
        if cur_y == 0 or cur_y == h - 1 or cur_x == 0 or cur_x == w - 1:
            # 우선 순위 큐 성질에 의해서 가장 먼저 가장자리 좌표의 값이 뽑힌다면 -> 그것이 바로 최단거리
            if ans > min_dist:
                ans = min_dist
            break

        # 상, 하, 좌, 우 탐색
        for dy, dx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            new_y, new_x = cur_y + dy, cur_x + dx
            # 범위를 넘거나, "E"를 만난다면 -> continue
            if new_y < 0 or new_y >= h or new_x < 0 or new_x >= w or MAP[new_y][new_x] == "E":
                continue
            new_dist = dist[cur_y][cur_x] + MAP[new_y][new_x]
            if new_dist < dist[new_y][new_x]:
                dist[new_y][new_x] = new_dist
                heappush(pq, (new_dist, new_y, new_x))

    print(ans)
