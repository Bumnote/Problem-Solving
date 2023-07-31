from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 노드의 개수 (0 <= n <= 50)
n_list = list(map(int, input().split()))  # 노드 리스트

r_n = int(input().strip())  # r_n: 삭제할 노드
vertex = [[] for _ in range(n)]
visited = [True] * n
root = 0

for index, node in enumerate(n_list):
    # 루트 노드와 삭제될 노드는 간선을 만들지 않는다.
    if node == -1:
        root = index  # 루트 노드의 번호만 저장
        continue
    if index == r_n or node == r_n:
        continue

    vertex[node].append(index)  # 부모 -> 자식: 단방향 그래프


def dfs(root):
    global cnt

    # 현재 노드의 원소(자식 노드)가 없는 경우 -> 리프 노드
    if vertex[root] == []:
        cnt += 1

    for nxt in vertex[root]:
        # 방문이 가능하다면 -> 깊이 탐색
        if visited[nxt]:
            visited[nxt] = False  # 방문 처리
            dfs(nxt)


cnt = 0
# 루트 노드를 지우는 경우 -> 리프노드가 존재하지 않는다.
if root == r_n:
    print(0)
else:
    visited[root] = False  # 방문 처리
    dfs(root)
    print(cnt)
