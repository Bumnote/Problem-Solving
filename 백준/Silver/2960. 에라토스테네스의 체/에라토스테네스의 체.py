from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, k = map(int, input().split())  # n까지, k번째 지우는 수
primes = [False, False] + [True] * (n - 1)


## 문제 해결 부분 ##
def solve():
    global cnt
    for i in range(2, len(primes)):
        if primes[i]:
            cnt += 1
            if cnt == k:
                return i
            for j in range(2 * i, len(primes), i):
                # 이미 처리했으면 횟수에 포함하지 않는다.
                if not primes[j]:
                    continue
                primes[j] = False  # 배수는 소수가 아님
                cnt += 1
                if cnt == k:
                    return j


cnt = 0
print(solve())
