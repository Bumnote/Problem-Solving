from sys import stdin

input = stdin.readline


def dfs(cur_v):
    global cnt

    for nxt_v in vertex[cur_v]:
        if canVisit[nxt_v]:
            canVisit[nxt_v] = False  # 방문 처리
            cnt += 1
            dfs(nxt_v)


n = int(input().rstrip())  # n: 컴퓨터의 수
m = int(input().rstrip())  # m: 연결된 컴퓨터 쌍의 수

vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    v1, v2 = map(int, input().split())
    vertex[v1].append(v2)
    vertex[v2].append(v1)

cnt = 0
canVisit = [True for _ in range(n + 1)]
canVisit[1] = False  # 방문 처리
dfs(1)

print(cnt)
