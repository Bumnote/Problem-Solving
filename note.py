from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 5)  # 재귀 깊이 확장
input = stdin.readline

n, k = map(int, input().split())  # n: 정점의 수, k: 깊이가 궁금한 정점
vertex = [[] for _ in range(n)]
visited = [True] * n

# 0번 정점이 루트인 트리
visited[0] = False  # 루트 방문 처리
for _ in range(n - 1):
    v1, v2 = map(int, input().split())  # v1 <-> v2: 양방향 그래프
    vertex[v1].append(v2)
    vertex[v2].append(v1)


def dfs(root, target, cnt):
    ans = 0
    for nxt in vertex[root]:
        # 다음 노드로 방문이 가능하다면 -> 깊이 탐색
        if visited[nxt]:
            visited[nxt] = False  # 방문 처리
            if nxt == target:
                return cnt + 1
            ans = dfs(nxt, target, cnt + 1)

    return ans


n_list = list(map(int, input().split()))
root, target = 0, 0
for i in range(n):
    # 0번을 부여받은 정점에서 부터 탐색 시작해야한다.
    if n_list[i] == 0:
        root = i
    # k번을 부여받은 정점의 깊이를 구해야한다.
    if n_list[i] == k:
        target = i

print(dfs(root, target, 0))
