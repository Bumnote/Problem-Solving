from sys import stdin

input = stdin.readline

t = int(input().rstrip())

for _ in range(t):
    n, m = map(int, input().split())  # n: 국가의 수, m: 비행기의 종류
    for _ in range(m):
        a, b = map(int, input().split())  # a <-> b: 연결

    print(n - 1)  # 연결 그래프이기 때문에 n개의 정점을 잇는 n - 1개의 간선이 최소이다.
