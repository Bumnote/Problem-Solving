from sys import stdin

input = stdin.readline


def dfs(cur_v):
    global res

    for nxt_v in vertex[cur_v]:
        # 방문이 가능하다면 -> dfs 탐색
        if visited[nxt_v]:
            visited[nxt_v] = False  # 방문 처리
            res.append(nxt_v)
            dfs(nxt_v)


n = int(input().strip())  # n: 도시의 수
m = int(input().strip())  # m: 계획에 속한 도시의 수

vertex = [[] for _ in range(n + 1)]  # 친구 관계 -> 연결 리스트

# 친구 관계 설정
for i in range(1, n + 1):
    rel = [0] + list(map(int, input().split()))
    for j in range(1, n + 1):
        if rel[j] == 1:
            vertex[i].append(j)

plan = list(map(int, input().split()))  # plan: 여행 계획한 도시 번호

visited = [True] * (n + 1)
flag = None
for i in range(1, n + 1):
    if visited[i]:
        visited[i] = False  # 방문 처리
        res = [i]
        dfs(i)
        flag = True
        for elem in plan:
            if elem not in res:
                flag = False
                break

        if flag:
            break

if flag:
    print("YES")
else:
    print("NO")
