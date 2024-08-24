from sys import stdin

input = stdin.readline

h, w, n, m = map(int, input().split())

i = 1 + n  # 행 
j = 1 + m  # 열

y = h // i if h % i == 0 else (h // i) + 1
x = w // j if w % j == 0 else (w // j) + 1
print(y * x)
