from sys import stdin

input = stdin.readline

idx, num = 0, 0
for i in range(1, 4):
    s = input().rstrip()
    # 주어진 3개의 문자들 중에서 숫자로 이루어진 문자를 찾는다.
    if s.isdigit():
        idx, num = i, int(s)

num = num + 4 - idx  # 다음 나올 숫자에 대한 정보
if num % 3 == 0 and num % 5 == 0:
    print("FizzBuzz")
elif num % 3 == 0 and num % 5 != 0:
    print("Fizz")
elif num % 3 != 0 and num % 5 == 0:
    print("Buzz")
else:
    print(num)
