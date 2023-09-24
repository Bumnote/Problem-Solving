from sys import stdin

input = stdin.readline

LEN = 1040
sieve = [False, True] + [True] * (LEN - 1)
for i in range(2, LEN + 1):
    # 소수에 해당한다면
    if sieve[i]:
        for j in range(2 * i, LEN + 1, i):
            sieve[j] = False  # 소수가 아님을 처리

s = input().strip()

total = 0
for elem in s:
    if "A" <= elem <= "Z":
        total += (ord(elem) - 38)
    else:
        total += (ord(elem) - 96)

if sieve[total]:
    print("It is a prime word.")
else:
    print("It is not a prime word.")
