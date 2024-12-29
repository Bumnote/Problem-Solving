from sys import stdin

input = stdin.readline

n = int(input().rstrip())
n_lst = list(map(int, input().split()))

numbers = [0 for _ in range(4)]
for i in range(n):
    numbers[n_lst[i]] += 1

# 그리디
total = 0

# 3점인 경우
MIN = min(numbers[1], numbers[2])
total += 3 * MIN
numbers[1] -= MIN
numbers[2] -= MIN

MIN = min(numbers[0], numbers[3])
total += 3 * MIN
numbers[0] -= MIN
numbers[3] -= MIN

# 2점인 경우
MIN = min(numbers[0], numbers[2])
total += 2 * MIN
numbers[0] -= MIN
numbers[2] -= MIN

MIN = min(numbers[1], numbers[3])
total += 2 * MIN
numbers[1] -= MIN
numbers[3] -= MIN

# 1점인 경우
MIN = min(numbers[0], numbers[1])
total += MIN
numbers[0] -= MIN
numbers[1] -= MIN

MIN = min(numbers[2], numbers[3])
total += MIN
numbers[2] -= MIN
numbers[3] -= MIN

# 정답 출력
print(total)
