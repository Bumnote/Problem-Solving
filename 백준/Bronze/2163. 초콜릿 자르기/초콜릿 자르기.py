from sys import stdin

input = stdin.readline

N, M = map(int, input().split())  # N x M 크기의 초콜릿
print(N * M - 1)
