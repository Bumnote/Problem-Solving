from sys import stdin

input = stdin.readline


def isPossible(y, x, n):
    global white, blue
    w_cnt, b_cnt = 0, 0
    for i in range(y, y + n):
        for j in range(x, x + n):
            if papers[i][j] == 0:
                w_cnt += 1
            else:
                b_cnt += 1

    # 해당 구역이 0으로만 이루어진 경우 -> 흰색 종이 개수 증가
    if w_cnt == n ** 2:
        white += 1
        return True
    # 해당 구역이 1로만 이루어진 경우 -> 파란색 종이 개수 증가
    elif b_cnt == n ** 2:
        blue += 1
        return True
    # 섞여있는 경우 -> 쪼개는 과정으로 재귀
    else:
        return False


def solution(y, x, n):
    global white, blue
    # 1칸짜리 종이까지 재귀된 경우 -> 종이의 색깔을 count -> return
    if n == 1:
        # 1칸짜리 4개를 전부 조사한다.
        for i in range(y, y + 2):
            for j in range(x, x + 2):
                if papers[i][j] == 0:
                    white += 1
                else:
                    blue += 1
        return

    for ny, nx in [(y, x), (y, x + n), (y + n, x), (y + n, x + n)]:
        if not isPossible(ny, nx, n):
            solution(ny, nx, n // 2)  # 재귀 진행


n = int(input().rstrip())  # n x n papers

papers = [list(map(int, input().split())) for _ in range(n)]  # 0: 흰 색, 1: 파란색
white, blue = 0, 0
# 전체가 하나의 색으로 도배되어있는 경우
if isPossible(0, 0, n):
    print(white)
    print(blue)
# 쪼개야 하는 경우
else:
    solution(0, 0, n // 2)
    print(white)
    print(blue)
