from sys import stdin

input = stdin.readline

n, k = map(int, input().split())  # n: 동전의 종류, k: 원하는 가치의 합

coins = [int(input().rstrip()) for _ in range(n)]
cnt = 0
for coin in coins[::-1]:
    if k >= coin:
        cnt += k // coin
        k %= coin

print(cnt)
