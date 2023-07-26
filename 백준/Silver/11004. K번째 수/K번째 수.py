from sys import stdin

input = stdin.readline

n, k = map(int, input().split())  # n: 숫자의 개수, k: 위치
print(sorted(list(map(int, input().split())))[k - 1])
