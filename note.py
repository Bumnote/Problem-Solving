from sys import stdin

input = stdin.readline


def dfs(node):
    global v_cnt, e_cnt

    for nxt in vertex[node]:
        # 다음 노드로 방문이 가능하다면 -> dfs 탐색
        if visited[nxt]:
            v_cnt += 1  # 정점의 개수 증가
            e_cnt += len(vertex[nxt])  # 간선의 개수 증가
            visited[nxt] = False  # 방문 처리
            dfs(nxt)


tc = 1
while True:
    n, m = map(int, input().split())  # n: 정점 수, m: 간선 수
    if n == 0 and m == 0:
        break

    vertex = [[] for _ in range(n + 1)]
    visited = [True] * (n + 1)
    for _ in range(m):
        s, e = map(int, input().split())  # s <-> e: 양방향 그래프
        vertex[s].append(e)
        vertex[e].append(s)

    cnt = 0
    for i in range(1, n + 1):
        # 아직 방문한 적이 없는 노드라면 -> dfs 탐색
        if visited[i]:
            v_cnt, e_cnt = 1, len(vertex[i])  # 정점의 개수, 간선의 개수
            visited[i] = False  # 방문 처리
            dfs(i)
            # 트리의 성질을 만족한다면 -> 트리의 개수 증가
            if (v_cnt - 1) * 2 == e_cnt:
                cnt += 1

    if cnt == 0:
        print(f"Case {tc}: No trees.")
    elif cnt == 1:
        print(f"Case {tc}: There is one tree.")
    else:
        print(f"Case {tc}: A forest of {cnt} trees.")

    tc += 1  # 테스트 케이스 증가
