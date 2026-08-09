from sys import stdin

input = stdin.readline

a, b = map(int, input().split())  # a: 몬스터 방어율, b: 유저의 방무

defend = a * (100 - b) / 100
print(0 if defend >= 100 else 1)
