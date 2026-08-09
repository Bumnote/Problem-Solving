from sys import stdin

input = stdin.readline

n = int(input().rstrip())

# 게임: 상근 시작
print("SK" if n % 2 == 1 else "CY")
