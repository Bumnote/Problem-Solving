from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 돌의 개수
stones = [0] + list(map(int, input().split()))
s = int(input().strip())  # s: 출발점


def dfs(cur_x):
    global cnt

    dist = stones[cur_x]  # 현재 위치에서 갈 수 있는 거리
    for nxt in (cur_x + dist, cur_x - dist):
        # 범위를 넘지 않고, 방문이 가능하다면 -> 깊이 탐색
        if 1 <= nxt <= n and visited[nxt]:
            visited[nxt] = False  # 방문 처리
            cnt += 1
            dfs(nxt)


visited = [True] * (n + 1)
visited[s] = False  # 현재 위치 방문처리
cnt = 1  # 갈 수 있는 돌의 개수
dfs(s)

print(cnt)
