import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline
result = 0


def dfs(v, c):
    global result
    if v_[v] == k:
        result = c
    for i in arr[v]:
        dfs(i, c + 1)


n, k = map(int, input().split())
arr = [[] for i in range(n)]
for i in range(n - 1):
    a, b = map(int, input().split())
    arr[a].append(b)
v_ = list(map(int, input().split()))

dfs(0, 0)
print(result)