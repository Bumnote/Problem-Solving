from sys import stdin

input = stdin.readline


def get_time(Z):
    time = 1 + (X - Z) / V_list[N]
    return time


T = int(input().strip())  # T: 테스트 케이스

for _ in range(T):
    N, X, Y = map(int, input().split())  # N: 사람의 수, X: 트랙의 길이, Y: 부스터 한계치
    V_list = [0] + list(map(int, input().split()))  # N개의 정수 -> 각 자동차의 속도 V[i]
    times = [0] + [X / V_list[i] for i in range(1, N + 1)]
    MIN_TIME = min(times[1:])
    # 부스터를 쓰지 않고도 단독 우승이 가능한 경우
    if times[N] == MIN_TIME and times[1:].count(MIN_TIME) == 1:
        print(0)
        continue
    # 나는 N번 선수
    # i번 참가자의 속도 - V[i] / 나는 처음 1초간 Z m/s 로 움직일 수 있다. (Z <= Y)
    left = 0
    right = Y
    Z = Y  # 정답 변수
    while left <= right:
        mid = (left + right) // 2
        
        if MIN_TIME > get_time(mid):
            right = mid - 1
            Z = min(Z, mid)
        else:
            left = mid + 1

    # 부스터를 최대치로 사용하고도 단독 우승이 불가능한 경우
    if Z == Y:
        print(-1)
    # 최적의 부스터를 찾아낸 경우
    else:
        print(Z)
