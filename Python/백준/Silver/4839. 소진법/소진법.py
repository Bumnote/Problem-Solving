from sys import stdin
from collections import deque

input = stdin.readline

primes = [2, 3, 5, 7, 11, 13, 17, 19, 23]
dp = [2]
for i in range(1, len(primes)):
    dp.append(dp[i - 1] * primes[i])

while True:
    n = int(input().rstrip())
    if n == 0:
        break

    num = n
    dq = deque()
    for i in range(len(dp) - 1, -1, -1):
        if n >= dp[i]:
            dq.appendleft([n // dp[i], i])
            n %= dp[i]

    print(f"{num} = ", end="")
    # 나머지가 생기지 않는 경우
    if n == 0:
        lst = []
        while dq:
            qt, idx = dq.popleft()
            st = f"{qt}"
            for i in range(idx + 1):
                st += f"*{primes[i]}"

            lst.append(st)
        print(*lst, sep=" + ")
    # 나머지가 생기는 경우
    else:
        lst = [n]
        while dq:
            qt, idx = dq.popleft()
            st = f"{qt}"
            for i in range(idx + 1):
                st += f"*{primes[i]}"

            lst.append(st)

        print(*lst, sep=" + ")
