from sys import stdin

input = stdin.readline


def get_cnt(MAP, h, b):
    remove_cnt, fill_cnt = 0, 0
    for i in range(n):
        for j in range(m):
            remove_cnt += max(0, MAP[i][j] - h)  # 현재 높이보다 높은 높이와의 차이만큼 삭제해야한다.
            fill_cnt += max(0, (h - MAP[i][j]))  # 현재 높이보다 낮은 높이와의 차이만큼 채워넣어야 한다.

    remove_time, fill_time = remove_cnt * 2, fill_cnt
    b += remove_cnt  # 인벤토리에 저장할 블록 수 증가

    time = 0
    if fill_cnt <= b:
        time = remove_time + fill_time
    else:
        time = int(1e9)

    return time


n, m, b = map(int, input().split())  # n x m MAP, b: 기존 인벤토리에 있는 블록의 개수

MIN, MAX = 256, 0
MAP = []
for i in range(n):
    MAP.append(list(map(int, input().split())))
    for j in range(m):
        MIN = min(MIN, MAP[i][j])  # 최소 높이 저장
        MAX = max(MAX, MAP[i][j])  # 최대 높이 저장

# 제거 후 저장 -> 2초
# 인벤토리 사용 -> 1초
time, height = int(1e9), 0  # 걸리는 시간, 높이

sec = 0
for h in range(MAX, MIN - 1, -1):
    total = get_cnt(MAP, h, b)
    if time > total:
        time = total
        height = h

print(f"{time} {height}")
