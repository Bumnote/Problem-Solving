from sys import stdin

input = stdin.readline

mn, mx = map(int, input().split())

LEN = 10 ** 6
sieve = [True for _ in range(LEN + 1)]

cnt = mx - mn + 1

for i in range(2, mx + 1):
    if i ** 2 > mx:
        break

    qt = mn // (i ** 2) if mn % (i ** 2) == 0 else (mn // (i ** 2)) + 1
    while qt * (i ** 2) <= mx:
        if sieve[qt * (i ** 2) - mn]:
            sieve[qt * (i ** 2) - mn] = False  # 제곱 ㅇㅇ 수
            cnt -= 1

        qt += 1

print(cnt)
