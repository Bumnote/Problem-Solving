from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 학생들의 수, m: 키를 비교한 횟수
INF = float('inf')
students = [[INF] * (n + 1) for _ in range(n + 1)]  # n명의 학생들은 키가 모두 다르다.

for _ in range(m):
    s1, s2 = map(int, input().split())  # s1 -> s2: 단방향 그래프
    students[s1][s2] = 1  # 인접행렬로 구현

## 문제 해결 부분 ##
for t in range(1, n + 1):
    students[t][t] = 0

# 플로이드 워셜 점화실 적용
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            # 연산이 대입보다 빠르다.
            if students[i][j] > students[i][k] + students[k][j]:
                students[i][j] = students[i][k] + students[k][j]

cnt = 0
for y in range(1, n + 1):
    flag = True
    for x in range(1, n + 1):
        # 한 노드에서 갈 수 없는 노드는 다른 노드에서 자신한테 올 수 있어야 한다.
        if students[y][x] == float('inf') and students[x][y] == float('inf'):
            flag = False
            break
    if flag:
        cnt += 1

print(cnt)
