from sys import stdin, maxsize

input = stdin.readline

N, M = map(int, input().split())  # N: 강의의 수, M: 블루레이의 개수
lectures = list(map(int, input().split()))  # 강의 정보


def get_cnt(x):
    total = 0
    cnt = 0
    for i in range(N):
        # 현재 mid 값보다 크다면 -> 블루레이 하나 소모
        if total + lectures[i] > x:
            cnt += 1  # 블루레이 증가
            total = 0
        total += lectures[i]

    # 마지막 값이 남아있다면 -> 블루레이 하나 소모
    if total != 0:
        cnt += 1

    return cnt


def binary_search():
    left = max(lectures)  # 강의의 최대길이가 곧 최대 횟수를 만든다.
    right = sum(lectures)  # 모든 강의 시간의 합이 곧 최소 횟수를 만든다.
    ans = maxsize  # 정답 변수

    while left <= right:
        mid = (left + right) // 2
        # M개의 블루레이로 담을 수 없는 경우 -> mid 값을 늘려야한다.
        if M < get_cnt(mid):
            left = mid + 1

        # M개의 블루레이로 담을 수 있는 경우 -> mid 값을 낮춰야한다.
        else:
            right = mid - 1
            ans = min(ans, mid)

    return ans


print(binary_search())
