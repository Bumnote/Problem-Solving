from sys import stdin

input = stdin.readline

MAX_LENGTH = 1_000_000
sieve = [0] + [1] * MAX_LENGTH  # 1은 모든 수의 약수이므로, 1로 초기화.
for i in range(2, MAX_LENGTH + 1):
    sieve[i] += sieve[i - 1]  # 바로 전 과정의 결과를 더해준다.
    # 2 * i의 수들은 i의 배수 즉, i를 약수로 가진다.
    for j in range(i, MAX_LENGTH + 1, i):
        sieve[j] += i  # 소수가 아님을 처리

tc = int(input().strip())  # tc: 테스트 케이스
for _ in range(tc):
    n = int(input().strip())  # (1<= n <= 1_000_000)
    print(sieve[n])
