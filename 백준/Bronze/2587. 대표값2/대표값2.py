from sys import stdin

input = stdin.readline

lst = [int(input().rstrip()) for _ in range(5)]
print(f"{sum(lst) // 5}\n{sorted(lst)[2]}")
