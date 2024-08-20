from sys import stdin

input = stdin.readline

n = int(input().rstrip())
if n == 1:
    print(1)
else:
    cnt = 1
    start = 2
    end = start + (6 * cnt)
    while True:

        if start <= n < end:
            print(cnt + 1)
            break

        cnt += 1
        start, end = end, end + (6 * cnt)
