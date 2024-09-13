from sys import stdin

input = stdin.readline

n = int(input().rstrip())

# 짝수 + 짝수 = 짝수
# 홀수 + 홀수 = 짝수
# 짝수 + 홀수 = 홀수

# n이 홀수인 경우 -> 짝수도, 홀수도 모두 가능(짝수가 1개 더 많은 경우 or 홀수가 1개 더 많은 경우)
if n % 2 == 1:
    print(0)
# n이 짝수인 경우
else:
    # 홀수가 짝수개인 경우 -> 항상 짝수
    if (n // 2) % 2 == 0:
        print(2)
    # 홀수가 홀수개인 경우 -> 항상 홀수
    else:
        print(1)
