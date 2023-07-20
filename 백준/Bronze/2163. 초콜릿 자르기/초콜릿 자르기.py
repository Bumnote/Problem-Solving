from sys import stdin

input = stdin.readline

N, M = map(int, input().split())  # N x M 크기의 초콜릿
ans = (min(N, M) - 1) + (min(N, M) * (max(N, M) - 1))
print(ans)
