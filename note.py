from sys import stdin

input = stdin.readline

n = int(input().strip())  # 1 <= n <= 8
n_list = []


def backtrack(cur_cnt):
    if cur_cnt > n:
        print(*n_list)
        return

    for i in range(1, n + 1):
        n_list.append(i)
        backtrack(cur_cnt + 1)
        n_list.pop()


backtrack(1)
