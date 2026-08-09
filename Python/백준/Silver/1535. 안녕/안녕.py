from sys import stdin

input = stdin.readline


def bt(happiness, power, lst):
    global MAX

    MAX = max(MAX, happiness)

    for i in range(n):
        # 원소가 존재하면서, 마지막 값보다 현재 i값이 더 작다면 내림차순이므로 유망하지 않음 -> continue
        if lst and lst[-1] > i:
            continue
        # 방문이 가능하고, power가 0보다 큰 경우 -> 유망하므로 backtracking 진행
        if not visited[i] and power - L[i] > 0:
            visited[i] = True  # 방문 처리
            lst.append(i)
            bt(happiness + J[i], power - L[i], lst)
            lst.pop()
            visited[i] = False  # 복원 처리

    return


n = int(input().rstrip())  # n: 사람 수
L = list(map(int, input().split()))  # L: 잃는 체력 리스트
J = list(map(int, input().split()))  # J: 기쁨 점수 리스트

power = 100
happiness = 0
MAX = 0
visited = [False for _ in range(n)]
bt(0, 100, [])

print(MAX)
