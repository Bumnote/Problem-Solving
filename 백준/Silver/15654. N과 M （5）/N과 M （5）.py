from sys import stdin

input = stdin.readline


def backtracking(cnt, lst):
    if m == cnt:
        print(*lst)
        return

    for i in range(n):
        if canVisit[i]:
            lst.append(n_list[i])
            canVisit[i] = False  # 방문 처리
            backtracking(cnt + 1, lst)
            canVisit[i] = True  # 복구 처리
            lst.pop()


n, m = map(int, input().split())  # n개의 자연수 중에서 m개를 고른 수열
n_list = sorted(map(int, input().split()))
canVisit = [True for _ in range(n)]

backtracking(0, [])
