from sys import stdin
from itertools import permutations

input = stdin.readline

n_list = [i for i in range(1, int(input().strip()) + 1)]
for elem in permutations(n_list, len(n_list)):
    print(*elem, sep=" ")
