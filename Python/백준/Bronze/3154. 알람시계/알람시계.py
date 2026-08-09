from sys import stdin

input = stdin.readline


def get_effort(y1, x1, y2, x2):
    return abs(y2 - y1) + abs(x2 - x1)


h, m = map(int, input().split(":"))
h_lst = []
m_lst = []

while h < 100:
    h_lst.append(h)
    h += 24

while m < 100:
    m_lst.append(m)
    m += 60

pos = {
    "1": [0, 0],
    "2": [0, 1],
    "3": [0, 2],
    "4": [1, 0],
    "5": [1, 1],
    "6": [1, 2],
    "7": [2, 0],
    "8": [2, 1],
    "9": [2, 2],
    "0": [3, 1]
}

MIN = float('inf')
ans = ""
for hh in h_lst:
    if hh < 10:
        hh = "0" + str(hh)
    for mm in m_lst:
        if mm < 10:
            mm = "0" + str(mm)

        hh, mm = str(hh), str(mm)
        time = hh + mm
        effort = 0
        for i in range(3):
            effort += get_effort(*pos[time[i]], *pos[time[i + 1]])

        if MIN > effort:
            MIN = effort
            ans = hh + ":" + mm

print(ans)
