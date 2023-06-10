from sys import stdin

input = stdin.readline


def solve(n):
    new_n = 0
    while n > 0:
        new_n += (n % 10)
        n //= 10

    return new_n


while True:
    ## 변수 입력 부분 ##
    n = int(input().strip())
    if n == 0:
        break

    ## 문제 해결 부분 ##
    new_n = 0

    while True:
        new_n = solve(n)

        # 일의 자리 수가 될 때까지 반복한다.
        if 1 <= new_n < 10:
            print(new_n)
            break

        n = new_n  # 갱신
