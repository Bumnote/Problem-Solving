from sys import stdin

input = stdin.readline


def binary_search(left, right, target):
    answer = 0
    while left <= right:
        mid = (left + right) // 2
        total = sum([max(0, height - mid) for height in heights])

        # 목표치보다 많다면 -> 더 적게 잘라야한다. -> 높이를 높인다.
        if total >= target:
            answer = max(answer, mid)
            left = mid + 1

        # 목표치보다 부족하다면 -> 더 많이 잘라야한다. -> 높이를 낮춘다.
        else:
            right = mid - 1

    return answer


n, m = map(int, input().split())  # n: 나무의 수, m: 원하는 나무의 길이
heights = list(map(int, input().split()))  # 나무의 높이 리스트

print(binary_search(0, max(heights), m))
