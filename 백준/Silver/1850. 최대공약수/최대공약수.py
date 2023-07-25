from sys import stdin

input = stdin.readline

a, b = map(int, input().split())  # a, b: A와 B를 이루는 1의 개수
if a < b:
    a, b = b, a

while b != 0:
    a, b = b, a % b

print("1" * a)
