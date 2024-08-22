from sys import stdin

input = stdin.readline

t = int(input().rstrip())

for _ in range(t):
    num = input().rstrip()
    MOD = int(num[-2:])
    year = int(num) + 1
    if year % MOD == 0:
        print("Good")
    else:
        print("Bye")
