from sys import stdin

input = stdin.readline

n, k = map(int, input().split())

sieve = [False, False] + [True] * (n - 1)

cnt, ans = 0, 0
for i in range(2, n + 1):
    if sieve[i]:
        cnt += 1
        if cnt == k:
            ans = i
        for j in range(i * 2, n + 1, i):
            if sieve[j]:
                sieve[j] = False  # 합성수 제거
                cnt += 1
                if cnt == k:
                    ans = j

print(ans)
