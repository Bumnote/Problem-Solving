from sys import stdin, maxsize

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n: 전제의 개수
INF = float('inf')
matrix = [[INF] * (58) for _ in range(58)]  # 알파벳의 개수 = 노드의 개수 = 26

## 자기 자신으로 가는 것은 0 으로 설정
for t in range(58):
    matrix[t][t] = 0

for _ in range(n):
    s, _, e = input().split()  # 모든 s는 e이다. s -> e: 단방향 그래프
    matrix[ord(s) - 65][ord(e) - 65] = 1

# 플로이드 워셜 점화식 구현
for k in range(58):
    for i in range(58):
        for j in range(58):
            if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                matrix[i][j] = matrix[i][k] + matrix[k][j]

lst = []
for y in range(58):
    for x in range(58):
        # 갈 수 있으면서, 자기 자신으로 향하는 방향이 아니라면 -> append()
        if matrix[y][x] != INF and y != x:
            lst.append((chr(y + 65), chr(x + 65)))

print(len(lst))
for s, e in lst:
    print(f"{s} => {e}")
