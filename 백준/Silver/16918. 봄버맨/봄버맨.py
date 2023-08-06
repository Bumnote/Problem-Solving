from sys import stdin

input = stdin.readline

# (1 <= R, C <= 200)
R, C, N = map(int, input().split())  # R x C MAP / N 초 후 상황

MAP = []
bomb = []
for y in range(R):
    MAP.append(list(input().strip()))
    for x in range(C):
        # 처음 입력된 폭탄의 위치를 저장한다.
        if MAP[y][x] == "O":
            bomb.append((y, x))

# 1초: 아무것도 하지 않는다. / 2초: 모든 공간을 폭탄으로 채운다. -> 2초부터 시작
cnt = 2

while cnt <= N:
    # 2초일 때는 모든 칸에 폭탄을 설치한다.
    if cnt % 2 == 0:
        for y in range(R):
            for x in range(C):
                MAP[y][x] = "O"

    # 3초일 때는 3초 전에 설치한 폭탄만을 터뜨린다.
    if cnt % 2 == 1:
        while bomb:
            b_y, b_x = bomb.pop()
            MAP[b_y][b_x] = "."  # 해당 폭탄 위치를 빈칸으로 변경

            for dy, dx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                new_y, new_x = b_y + dy, b_x + dx
                # 범위를 넘거나, 폭탄이 아닌 경우는 continue
                if new_y < 0 or new_y >= R or new_x < 0 or new_x >= C or MAP[new_y][new_x] == ".":
                    continue
                # 인접한 폭탄은 폭발없이 파괴된다.
                MAP[new_y][new_x] = "."

        # 터뜨린 뒤, 남아 있는 폭탄들의 위치를 저장
        for y in range(R):
            for x in range(C):
                # 폭탄의 위치를 bomb 리스트에 저장
                if MAP[y][x] == "O":
                    bomb.append((y, x))

    cnt += 1

for elem in MAP:
    print(*elem, sep="")
