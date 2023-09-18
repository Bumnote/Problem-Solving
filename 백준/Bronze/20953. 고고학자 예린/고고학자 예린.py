from sys import stdin

input = stdin.readline

t = int(input().strip())  # t: 테스트 케이스

for _ in range(t):
    a, b = map(int, input().split())  #

    sum = (a + b) * ((a + b - 1) * (a + b) // 2)
    print(sum)
