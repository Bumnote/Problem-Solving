from sys import stdin
from math import isqrt
from collections import deque

input = stdin.readline

# 10 이하의 소수 -> 4개
# 100 이하의 소수 -> 25개
# 1000 이하의 소수 -> 168개
# 10000 이하의 소수 -> 1229개

# 에라토스테네스의 체 구현
sieve = [False, False] + [True] * 10_000
for i in range(2, isqrt(10_000) + 1):
    if sieve[i]:
        for j in range(2 * i, 10_001, i):
            sieve[j] = False  # 소수가 아님을 처리

tc = int(input().strip())  # tc: 테스트 케이스


def bfs(s, e):
    deq = deque()
    deq.append((s, 0))  # (시작 소수, 횟수)
    visited = [True] * 10_001
    visited[s] = False  # 방문 표시

    while deq:
        cur_n, cur_cnt = deq.popleft()
        if cur_n == e:
            return cur_cnt

        n_list = list(map(int, str(cur_n)))
        for i in range(4):
            temp = n_list[i]
            for j in range(0, 10):
                # 가장 큰 자리 수는 0이 되면 안된다.
                if i == 0 and j == 0:
                    continue
                # 원래의 숫자는 신경쓰지 않아도 된다.
                if temp == j:
                    continue
                n_list[i] = j
                new_n = int("".join(map(str, n_list)))

                if visited[new_n] and sieve[new_n]:
                    visited[new_n] = False  # 방문 처리
                    deq.append((new_n, cur_cnt + 1))
            n_list[i] = temp  # 다시 원래 숫자로 복원
    return -1


for _ in range(tc):
    s, e = map(int, input().split())  # s -> e (s, e: 4자리 소수)

    cnt = bfs(s, e)
    if cnt == -1:
        print("Impossible")
    else:
        print(cnt)
