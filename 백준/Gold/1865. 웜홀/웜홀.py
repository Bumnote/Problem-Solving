from sys import stdin, maxsize

input = stdin.readline


def bf(s):
    dist = [200000000 for _ in range(n + 1)]
    dist[s] = 0  # 출발점의 거리는 0

    # 반복 횟수는 n - 1 / 사이클이 발생하는 것을 찾기 위해서 n 번째도 반복문을 돌린다.
    for i in range(1, n + 1):
        # 각 노드에 대한 모든 간선을 탐색한다.
        for cur_v in range(1, n + 1):
            for nxt_v, nxt_dist in vertex[cur_v].items():
                new_dist = dist[cur_v] + nxt_dist
                if new_dist < dist[nxt_v]:
                    dist[nxt_v] = new_dist
                    if i == n:
                        return 1  # 음의 순환이 발생한 경우

    return 0  # 음의 순환이 없는 경우


tc = int(input().rstrip())

for _ in range(tc):
    n, m, w = map(int, input().split())  # n: 지점의 개수, m: 도로의 개수, w: 웜홀의 개수

    vertex = [{} for _ in range(n + 1)]
    for _ in range(m):
        s, e, t = map(int, input().split())  # s <-> e: 걸리는 시간 t
        # 처음 들어오는 정보라면 -> 입력한다.
        if e not in vertex[s]:
            vertex[s][e] = t
        # 하나의 도로에 대해서 더 짧은 거리가 들어오면 -> 최단 거리를 저장한다.
        else:
            vertex[s][e] = min(vertex[s][e], t)

        # 양방향이므로, 반대 방향으로도 값 추가
        if s not in vertex[e]:
            vertex[e][s] = t
        else:
            vertex[e][s] = min(vertex[e][s], t)

    for _ in range(w):
        s, e, t = map(int, input().split())  # s -> e: 줄어드는 시간 t
        if e not in vertex[s]:
            vertex[s][e] = -t  # 시간이 감소하므로 가중치가 음수
        else:
            vertex[s][e] = min(-t, vertex[s][e])

    negative_cycle = bf(1)

    if negative_cycle > 0:
        print("YES")
    else:
        print("NO")
