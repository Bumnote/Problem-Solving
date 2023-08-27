from sys import stdin, maxsize

INF = maxsize
input = stdin.readline


# i -> j로 가는 모든 경로를 구하는 함수
def find_path(i, j):
    if path[i][j] == 0:
        return []

    k = path[i][j]
    return find_path(i, k) + [k] + find_path(k, j)


n = int(input().strip())  # n: 도시의 개수
m = int(input().strip())  # m: 버스의 개수
mat = [[INF] * (n + 1) for _ in range(n + 1)]
path = [[0] * (n + 1) for _ in range(n + 1)]  # 경로 저장

# 자기 자신으로 가는 비용은 0으로 초기화
for t in range(1, n + 1):
    mat[t][t] = 0

for _ in range(m):
    a, b, c = map(int, input().split())
    # 같은 버스 노선이 존재한다면 -> 더 짧은 거리를 저장한다.
    mat[a][b] = min(mat[a][b], c)  # a -> b: 비용 c

# 플로이드 워셜 점화식 구현
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if mat[i][j] > mat[i][k] + mat[k][j]:
                mat[i][j] = mat[i][k] + mat[k][j]
                path[i][j] = k

for i in range(1, n + 1):
    for j in range(1, n + 1):
        print(mat[i][j] if mat[i][j] != INF else 0, end=" ")
    print()

# n x n 줄 출력
for i in range(1, n + 1):
    for j in range(1, n + 1):
        # 경로가 아예 존재하지 않는 경우
        if mat[i][j] == 0 or mat[i][j] == INF:
            print(0)
        # 직접 연결되어 거쳐가는 정점이 없는 경우
        elif path[i][j] == 0:
            print(f"{2} {i} {j}")
        # 거쳐가는 정점이 있는 경우
        else:
            route = [i] + find_path(i, j) + [j]
            print(f"{len(route)}", end=" ")  # 최소 비용에 포함된 도시의 개수
            print(*route)  # i -> j 경로 출력
