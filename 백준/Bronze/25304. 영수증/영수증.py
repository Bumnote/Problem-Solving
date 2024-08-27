from sys import stdin

input = stdin.readline

x = int(input().rstrip())
n = int(input().rstrip())

total = 0
for _ in range(n):
    a, b = map(int, input().split())  # a: 물건의 가격, b: 물건의 개수
    total += b * a

print("Yes" if total == x else "No")
