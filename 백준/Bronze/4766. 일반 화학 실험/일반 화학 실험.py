from sys import stdin

input = stdin.readline

temper = float(input().rstrip())

while True:
    nxt_temper = float(input().rstrip())
    if int(nxt_temper) == 999:
        break

    diff = nxt_temper - temper
    print(f"{diff:.2f}")

    temper = nxt_temper
