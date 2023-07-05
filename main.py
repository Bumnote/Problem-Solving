from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 도시의 개수, m: 도로의 개수
INF = float('inf')
matrix = [[INF] * (n + 1) for _ in range(n + 1)]
for _ in range(m):
    A, B, T = map(int, input().split())  # A -> B: T 시간
    matrix[A][B] = T  # 단방향 인접행렬

for t in range(1, n + 1):
    matrix[t][t] = 0

total = int(input().strip())  # 준형이와 친구들의 총 인원
citys = list(map(int, input().split()))  # k명의 도시 번호

## 문제 해결 부분 ##
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                matrix[i][j] = matrix[i][k] + matrix[k][j]

ans = INF
lst = []
for v in range(1, n + 1):
    temp = 0
    for city in citys:
        # 왕복 거리의 최댓값의 최소를 가지는 도시만을 구한다.
        temp = max(temp, matrix[city][v] + matrix[v][city])
    # 왕복 거리의 최댓값의 최소라면 -> 그 도시가 정답이다.
    if ans > temp:
        ans = temp
        lst = [v]
    # 왕복 거리의 최댓값의 최솟값이 같다면 -> append
    elif ans == temp:
        lst.append(v)

print(*lst, sep=" ")
