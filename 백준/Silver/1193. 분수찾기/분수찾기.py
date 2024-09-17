from sys import stdin

input = stdin.readline


def solution(x, n):
    while True:
        s = n * (n + 1) // 2
        e = (n + 1) * (n + 2) // 2

        if s < x <= e:
            up, down = 1, n + 1
            # 분모가 홀수인 경우 -> 분모가 큰 상태로 시작
            if down % 2 == 1:
                up, down = down, up
                for i in range(s + 1, e + 1):
                    if i == x:
                        ans = f"{up}/{down}"
                        return ans
                    up -= 1
                    down += 1
            # 분모가 짝수인 경우 -> 분모가 작은 상태로 시작
            else:
                for i in range(s + 1, e + 1):
                    if i == x:
                        ans = f"{up}/{down}"
                        return ans
                    up += 1
                    down -= 1

        n += 1


x = int(input().rstrip())

print(solution(x, 0))
