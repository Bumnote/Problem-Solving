from sys import stdin

input = stdin.readline

t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())  # n: 의상 수

    dic = {}
    for _ in range(n):
        name, wear = input().split()
        # 의상의 종류가 없다면 -> 새롭게 종류 추가
        if wear not in dic:
            dic[wear] = 1
        # 해당 의상 종류가 이미 있다면 -> 이름 추가
        else:
            dic[wear] += 1

    total = 1
    for cnt in dic.values():
        total *= (cnt + 1)

    print(total - 1)  # 알몸인 경우를 제외한 후 출력
