from sys import stdin

input = stdin.readline


# 대표 노드를 반환해주는 함수 
def find(x):
    if uf[x] == x:
        return x

    uf[x] = find(uf[x])
    return uf[x]


# 두 노드를 연결시켜주는 함수 
def union(a, b):
    a, b = find(a), find(b)
    uf[a] = b


n, m = map(int, input().split())  # n: 강의 수, m: 건물 쌍의 수
uf = [i for i in range(n + 1)]

for _ in range(m):
    i, j = map(int, input().split())  # i <-> j: i번 건물과 j번 건물을 연결
    union(i, j)

lectures = list(map(int, input().split()))

cnt = 0
for i in range(n - 1):
    if find(lectures[i]) != find(lectures[i + 1]):
        cnt += 1

print(cnt)
