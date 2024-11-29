from sys import stdin

input = stdin.readline


def f(x):
    return x % 10


n, k = map(int, input().split())
cnt = 0

lst = []
for i in range(1, n + 1):
    if f(i) != f(k) and f(i) != f(2 * k):
        cnt += 1
        lst.append(i)
print(cnt)
print(*lst if lst else "")
