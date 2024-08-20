from sys import stdin

input = stdin.readline

# 낮: a 상승 / 밤: b 하강 / v: 최종 높이
a, b, v = map(int, input().split())
# 하루만큼 올라갈 수 있는 높이: a - b
# v에 오르기 전 하루 전에는 a보다 같거나 짧은 거리가 남아있어야 한다.
rise_day = a - b
height = v - a
day = 0

if a == v:
    print(1)
# 여러 날을 거쳐 올라갈 수 있는 거리가 v - a 이라면 -> 다음 날 낮에 등반 가능
elif height % rise_day == 0:
    day += ((height // rise_day) + 1)
    print(day)
# 여러 날을 거쳐 올라갈 수 있는 거리가 v - a에 미치지 못한다면
# 다음 날 a - b만큼 올라가고, 그 다음 낮에 a만큼 올라가서 등반 가능
else:
    day += ((height // rise_day) + 2)
    print(day)
