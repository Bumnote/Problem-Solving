from sys import stdin

input = stdin.readline

s = input().strip()  # s: 주어지는 2진수

# 2진수 -> 10진수
Z = int("0b" + s, 2)

print(oct(Z)[2:])
