from sys import stdin

input = stdin.readline

tc = int(input().strip())
# 에라토스테네스의 체 구현
sieve = [False, False] + [True] * 10_000

for i in range(2, 10_001):
    # 소수에 대해서
    if sieve[i]:
        # 소수의 배수들은 소수가 아니다.
        for j in range(2 * i, 10_001, i):
            sieve[j] = False  # 소수가 아닌 수들

for _ in range(tc):
    n = int(input().strip())  # n: 짝수 (4 <= n <= 10_000)
    MIN = 10_001
    a, b = 0, 0
    for i in range(2, (n // 2) + 1):
        # 짝수 n을 만들 수 있는 두 소수에 대해서
        if sieve[i] and sieve[n - i]:
            # 사이의 최솟값에 대해서만 갱신
            if MIN > n - 2 * i:
                MIN = n - 2 * i
                a, b = i, n - i

    print(f"{a} {b}")
