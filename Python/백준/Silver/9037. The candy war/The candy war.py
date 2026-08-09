from sys import stdin

input = stdin.readline


def make_even_candies():
    for i in range(n):
        if candies[i] % 2 == 1:
            candies[i] += 1


t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())
    candies = list(map(int, input().split()))

    cnt = 0
    while True:
        make_even_candies()

        if len(set(candies)) == 1:
            print(cnt)
            break

        nxt = [0 for _ in range(n)]
        for i in range(1, n + 1):
            nxt[i % n] = candies[i - 1] // 2

        for i in range(n):
            candies[i] = candies[i] // 2 + nxt[i]

        cnt += 1
