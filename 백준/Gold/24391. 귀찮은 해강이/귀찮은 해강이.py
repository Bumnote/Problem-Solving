from sys import stdin

input = stdin.readline


def find(x):
    if uf[x] != x:
        uf[x] = find(uf[x])
    return uf[x]


def union(x, y):
    x_root, y_root = find(x), find(y)

    if x_root == y_root:
        return

    if x_root > y_root:
        x_root, y_root = y_root, x_root

    uf[y_root] = x_root


n, m = map(int, input().split())  # n: 강의 개수, m: 건물 쌍의 개수
uf = [i for i in range(n + 1)]

for _ in range(m):
    i, j = map(int, input().split())  # i - j 연결
    # 둘이 연결되어있지 않다면 -> 연결
    if find(i) != find(j):
        union(i, j)

# 구해야하는 것은 집합의 개수
cnt = 0
codes = list(map(int, input().split()))
for i in range(n - 1):
    # 현재 강의와 다음 강의가 같은 집합이 아니라면 -> 카운트 +1
    if find(uf[codes[i]]) != find(uf[codes[i + 1]]):
        cnt += 1

print(cnt)
