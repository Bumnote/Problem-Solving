from sys import stdin

input = stdin.readline

n = int(input().strip())
n_list = list(map(int, input().strip()))
print(sum(n_list))
