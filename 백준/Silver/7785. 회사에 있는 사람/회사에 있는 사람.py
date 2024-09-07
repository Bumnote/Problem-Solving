from sys import stdin

input = stdin.readline

n = int(input().rstrip())

person_exist = set()
for _ in range(n):
    name, sign = input().split()
    if sign == "enter":
        person_exist.add(name)
    else:
        person_exist.discard(name)

print(*sorted(person_exist, reverse=True), sep='\n')
