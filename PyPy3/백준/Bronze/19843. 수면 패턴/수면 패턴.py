from sys import stdin

input = stdin.readline

t, n = map(int, input().split())  # t: 자야 할 시간, n: 평일 동안 잠든 횟수

total = 0
dic = {"Mon": 0, "Tue": 1, "Wed": 2, "Thu": 3, "Fri": 4}
for _ in range(n):
    d1, h1, d2, h2 = input().split()
    diff = dic[d2] - dic[d1]
    total += int(h2) + 24 * diff - int(h1)

# 주말에 잠을 자지 않아도 충분한 경우
if total >= t:
    print(0)
# 주말에 자야하는 경우 || 주말 내내 잠을 자도 부족한 경우
else:
    remain = t - total
    print(remain if remain <= 48 else - 1)
