from sys import stdin

input = stdin.readline

LEN = 10_000

sieve = [False] + [True] * LEN

for i in range(1, LEN + 1):
    num = i
    if sieve[True]:
        while True:
            nxt = num + sum(list(map(int, str(num))))
            if nxt > LEN or not sieve[nxt]:
                break

            sieve[nxt] = False
            num = nxt

for num in range(1, LEN + 1):
    if sieve[num]:
        print(num)
