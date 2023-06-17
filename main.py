from sys import stdin
from itertools import combinations

input = stdin.readline

n = int(input().strip())
days = [list(map(int, input().split())) for _ in range(n)]
max_student = -1
answer = [0, 0, 0, 0, 0]
a1, a2 = 0, 0

for d1, d2 in combinations([0, 1, 2, 3, 4], 2):
    p_student = 0
    for i in range(n):
        if days[i][d1] == 1 and days[i][d2] == 1:
            p_student += 1

    if max_student < p_student:
        max_student = p_student
        a1, a2 = d1, d2

answer[a1], answer[a2] = 1, 1
print(max_student)
print(*answer, sep=" ")
