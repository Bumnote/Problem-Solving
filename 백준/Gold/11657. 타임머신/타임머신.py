from sys import stdin

input = stdin.readline


def bf(s):
    dist[s] = 0  # 시작점 거리 초기화

    # n번 시행한다.
    for i in range(1, n + 1):
        # 모든 노드를 n - 1번 돌면 무조건 최단거리가 보장됨을 활용
        for cur_v in range(1, n + 1):
            for nxt_v, nxt_dist in vertex[cur_v]:
                new_dist = dist[cur_v] + nxt_dist  # 새로운 거리
                # 거리가 INF가 아니고, 더 짧게 갱신이 된다면 -> 갱신
                if dist[cur_v] != INF and new_dist < dist[nxt_v]:
                    dist[nxt_v] = new_dist  # 거리 갱신
                    # n번 째에도 갱신이 된다면 -> 음의 순환이 존재
                    if i == n:
                        return True

    return False


n, m = map(int, input().split())

vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())  # a -> b: 시간 c
    vertex[a].append((b, c))

INF = int(1e9)
dist = [INF for _ in range(n + 1)]

negative_cycle = bf(1)

# 음의 순환이 존재한다면 -> -1
if negative_cycle:
    print(-1)
# 음의 순환이 존재하지 않는 경우
else:
    for i in range(2, n + 1):
        print(dist[i] if dist[i] != INF else -1)
