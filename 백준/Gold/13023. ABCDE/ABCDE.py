from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 5)
input = stdin.readline

n, m = map(int, input().split())  # n: 사람의 수, m: 관계의 수
vertex = [[] for _ in range(n)]

for _ in range(m):
    a, b = map(int, input().split())  # a <-> b: 친구 관계
    vertex[a].append(b)
    vertex[b].append(a)


def dfs(x):
    global cnt, flag
    if cnt >= 5:
        flag = True
        return

        # 한 경로에 있는 요소 개수를 파악하기 위해선 복원 처리가 필요
    for nxt in vertex[x]:
        if visited[nxt]:
            cnt += 1
            visited[nxt] = False  # 방문 처리
            dfs(nxt)
            visited[nxt] = True  # 복원 처리
            cnt -= 1


visited = [True] * n
flag = False
for i in range(n):
    # 방문이 가능하다면 -> dfs 진행
    if visited[i]:
        visited[i] = False  # 방문 처리
        cnt = 1
        dfs(i)
        visited[i] = True  # 복원 처리
        if flag:
            break

if flag:
    print(1)
else:
    print(0)
