from sys import stdin, maxsize
from heapq import heappush, heappop

INF = maxsize
input = stdin.readline

T = int(input().strip())  # T: 테스트 케이스

for tc in range(1, T + 1):

    n, p, m = map(int, input().split())  # n: 도시의 숫자, p: 친구의 수, m: 도로의 숫자
    mat = [[INF] * (n + 1) for _ in range(n + 1)]

    # 자기 자신으로 가는 거리는 0으로 초기화
    for r in range(1, n + 1):
        mat[r][r] = 0

    p_list = []
    for _ in range(p):
        xi, vi = map(int, input().split())  # xi: i번째 친구가 출발한 도시, vi: i번째 친구가 거리 1당 걸리는 시간
        p_list.append((xi, vi))

    for _ in range(m):
        dj, lj, *c_list = map(int, input().split())  # dj: 도로의 거리, lj: 도로를 지나는 도시의 개수, c_listL: 도시 번호
        # 양방향 구현
        for j in range(lj - 1):
            mat[c_list[j]][c_list[j + 1]] = dj
            mat[c_list[j + 1]][c_list[j]] = dj

    # 플로이드 워셜 점화식 구현
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if mat[i][j] > mat[i][k] + mat[k][j]:
                    mat[i][j] = mat[i][k] + mat[k][j]

    ans = INF
    for y in range(1, n + 1):
        total = 0
        flag = True  # 모든 친구들이 한 곳에 모일 수 있는지 판단하는 변수
        for x, dist in p_list:
            # 친구들이 한 곳에 모일 수 없는 경우 -> 고려하지 않는다.
            if mat[x][y] == INF:
                flag = False
                break
            # 거리의 합이 아니라, 모든 친구들이 한 곳에 모일 수 있는 시간 즉, 가장 오래 걸리는 시간 기준이다.
            total = max(total, mat[x][y] * dist)
        # 모든 친구들이 한 곳에 모일 수 있는 경우에만 ans 갱신
        if flag:
            ans = min(ans, total)

    # 모든 친구들이 한 곳에 모일 수 없는 경우에는 ans == INF 이다.
    print(f"Case #{tc}: {ans if ans != INF else -1}")
