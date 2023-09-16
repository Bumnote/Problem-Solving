from sys import stdin

input = stdin.readline

n, m = map(int, input().split())  # n: 100원 동전 개수, m: 초코바 가격

money = 100 * n
if money < m:
    print("No")
else:
    print("Yes")
