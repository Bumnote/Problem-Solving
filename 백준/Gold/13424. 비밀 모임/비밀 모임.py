from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
tc = int(input().strip())  # 테스트 케이스
INF = float('inf')
for _ in range(tc):
    n, m = map(int, input().split())  # n: 방의 개수, m: 통로의 개수
    matrix = [[INF] * (n + 1) for _ in range(n + 1)]

    for v in range(1, n + 1):
        matrix[v][v] = 0

    for _ in range(m):
        a, b, c = map(int, input().split())  # a <-> b: 거리 c
        matrix[a][b] = c
        matrix[b][a] = c

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                    matrix[i][j] = matrix[i][k] + matrix[k][j]

    k = int(input().strip())  # k: 친구의 수
    k_list = list(map(int, input().split()))  # k개의 방의 번호

    temp = INF
    ans = 0
    for y in range(1, n + 1):
        total = 0
        for x in k_list:
            total += matrix[x][y]
        if temp > total:
            temp = total
            ans = y

    print(ans)
