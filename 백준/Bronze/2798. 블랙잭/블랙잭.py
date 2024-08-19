from sys import stdin

input = stdin.readline


def backtracking(cnt, total):
    global answer
    # 카드의 합이 요구한 숫자보다 크면 -> return
    if total > m:
        return

    if cnt == 3:
        answer = max(answer, total)
        return

    for i in range(n):
        # 해당 숫자를 선택할 수 있다면 -> backtracking
        if canVisit[i]:
            canVisit[i] = False  # 방문 처리
            backtracking(cnt + 1, total + lst[i])
            canVisit[i] = True  # 복구 처리


n, m = map(int, input().split())
lst = list(map(int, input().split()))

answer = 0
canVisit = [True for _ in range(n + 1)]
backtracking(0, 0) # 백트래킹을 활용한 브루트 포스

print(answer)
