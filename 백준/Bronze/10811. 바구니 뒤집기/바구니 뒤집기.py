from sys import stdin

input = stdin.readline

n, m = map(int, input().split())  # n: 바구니 개수, m: 넣을 공

lst = [i for i in range(n + 1)]
for _ in range(m):
    i, j = map(int, input().split())  # i번 바구니와 j번 바구니의 공을 서로 뒤바꾼다.
    for t in range((j - i + 1) // 2):
        lst[i + t], lst[j - t] = lst[j - t], lst[i + t]

print(*lst[1:])
