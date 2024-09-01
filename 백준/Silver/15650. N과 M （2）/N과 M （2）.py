from sys import stdin

input = stdin.readline


def backtracking(cnt, lst):
    if cnt == m:
        print(*lst)
        return

    for i in range(1, n + 1):
        # 원소가 존재하면서, 마지막 값보다 현재 i값이 더 작다면 내림차순이므로 유망하지 않음 -> continue
        if lst and lst[-1] > i:
            continue
            # 해당 수를 가질 수 있다면 -> 해당 수를 추가
        if canVisit[i]:
            canVisit[i] = False  # 방문 처리
            lst.append(i)
            backtracking(cnt + 1, lst)
            lst.pop()
            canVisit[i] = True  # 복구 처리


# 1부터 N까지 자연수 중에서 중복없이 M개를 고른 수열
# 고른 수열은 오름차순
n, m = map(int, input().split())

canVisit = [True for _ in range(n + 1)]
backtracking(0, [])
