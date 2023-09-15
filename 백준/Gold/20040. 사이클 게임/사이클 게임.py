from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 6)
input = stdin.readline


def find(x):
    if uf[x] == x:
        return x

    uf[x] = find(uf[x])
    return uf[x]


def union(a, b):
    a, b = find(a), find(b)
    uf[a] = b


n, m = map(int, input().split())  # n: 점의 개수, m: 차례의 수
uf = [i for i in range(n)]  # union-find list

ans = 0
for j in range(1, m + 1):
    u, v = map(int, input().split())  # u <-> v: 연결
    # 이미 같은 집합인데 다시 연결한다면 -> 사이클 발생
    if find(u) == find(v) and ans == 0:
        ans = j
        continue

    # 이미 갱신이 되었다면 -> union 작업을 하지 않아도 된다.
    if ans != 0:
        continue
    union(u, v)

print(ans)
