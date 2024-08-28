from sys import stdin

input = stdin.readline

lst = list(map(int, input().split()))
ans = [1, 1, 2, 2, 2, 8]

for a, b in zip(lst, ans):
    print(b - a, end=" ")
