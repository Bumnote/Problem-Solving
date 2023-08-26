from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 시험장의 개수
Ai = list(map(int, input().split()))  # Ai: 응시자의 수
b, c = map(int, input().split())

cnt = n
for student in Ai:
    student -= b
    if student <= 0:
        continue
    else:
        cnt += ((student // c) + (0 if student % c == 0 else 1))

print(cnt)
