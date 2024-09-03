from sys import stdin

input = stdin.readline


def bt(cnt, lst):
    if cnt == m:
        print(*lst)
        return

    for i in range(1, n + 1):
        if lst and lst[-1] > i:
            continue

        lst.append(i)
        bt(cnt + 1, lst)
        lst.pop()


n, m = map(int, input().split())  # 1부터 n 까지 자연수 중에서 m개를 고른 수열
bt(0, [])
