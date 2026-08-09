from sys import stdin
from itertools import combinations

input = stdin.readline

n = int(input().rstrip())

contest = []
for i in range(1, n + 1):
    power, ring = map(int, input().split())
    contest.append((i, power, ring))

dic = {i: 0 for i in range(1, n + 1)}
for comb in combinations(contest, 2):
    a, a_power, a_ring = comb[0]
    b, b_power, b_ring = comb[1]

    a_of_game = a_power + b_power * a_ring
    b_of_game = b_power + a_power * b_ring

    if a_of_game > b_of_game:
        dic[a] += 1
    else:
        dic[b] += 1

for person, cnt in sorted(dic.items(), key=lambda x: x[1], reverse=True):
    print(person)
