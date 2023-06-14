from sys import stdin, setrecursionlimit

input = stdin.readline
setrecursionlimit(500000)

## 변수 입력 부분 ##
n = int(input().strip())
vertex = [[] for _ in range(n + 1)]
visited = [True] * (n + 1)

# 임의의 라인을 입력받는다.
for _ in range(n - 1):
    v1, v2 = map(int, input().split())
    vertex[v1].append(v2)
    vertex[v2].append(v1)


## 문제 해결 부분 ##
def dfs(x, dist):
    global cnt

    for elem in vertex[x]:
        # 방문이 가능한 노드라면 -> 깊이 탐색
        if visited[elem]:
            # 다음 노드의 연결 요소 개수가 1이라면 -> leaf node
            if len(vertex[elem]) == 1:
                cnt += (dist + 1)
            visited[elem] = False  # 방문 처리
            dfs(elem, dist + 1)


cnt = 0
visited[1] = False  # 루트 노드 방문 처리
dfs(1, 0)

# leaf 노드까지의 거리 합이 홀수이면 성원이가 이긴다.
print("Yes" if cnt % 2 == 1 else "No")
