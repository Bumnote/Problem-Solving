from sys import stdin

input = stdin.readline

n = int(input().rstrip())

persons = []
for i in range(1, n + 1):
    age, name = input().split()
    persons.append((i, int(age), name))

# 1. 나이 순서 -> 2. 가입한 순서
for idx, age, name in sorted(persons, key=lambda x: (x[1], x[0])):
    print(f"{age} {name}")
