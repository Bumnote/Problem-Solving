from sys import stdin

input = stdin.readline

n = int(input().rstrip())
lst = [i for i in range(1, n + 1)]
lst[-1] = 53

print(n)
print(*lst)
