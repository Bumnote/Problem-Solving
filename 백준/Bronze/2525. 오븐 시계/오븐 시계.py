from sys import stdin

input = stdin.readline

a, b = map(int, input().split())  # a시 b분
c = int(input().rstrip())  # c: 요리하는데 필요한 시간(분)

h = (a + (c // 60) + (b + (c % 60)) // 60) % 24
m = (b + (c % 60)) % 60

print(f"{h} {m}")
