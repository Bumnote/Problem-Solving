from sys import stdin, maxsize

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n: 전제의 개수
INF = maxsize
matrix = [[INF] * (26) for _ in range(26)]  # 알파벳의 개수 = 노드의 개수 = 26

for t in range(26):
    matrix[t][t] = 0

for _ in range(n):
    s, _, e = input().split()  # 모든 s는 e이다. s -> e: 단방향 그래프
    matrix[ord(s) - 97][ord(e) - 97] = 1

for k in range(26):
    for i in range(26):
        for j in range(26):
            if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                matrix[i][j] = matrix[i][k] + matrix[k][j]

m = int(input().strip())  # m: 질문의 개수
for _ in range(m):
    s, _, e = input().split()
    if matrix[ord(s) - 97][ord(e) - 97] != INF:
        print("T")
    else:
        print("F")
