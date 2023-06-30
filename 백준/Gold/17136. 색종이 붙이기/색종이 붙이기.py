from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
board = [list(map(int, input().split())) for _ in range(10)]  # 10 x 10
ans = 25
paper = [0] * 6  # 사용한 색종이 개수 (크기 1 ~ 5)


## 문제 해결 부분 ##
def is_possible(y, x, sz):
    if paper[sz] == 5:
        return False

    if y + sz > 10 or x + sz > 10:
        return False

    for i in range(sz):
        for j in range(sz):
            if board[y + i][x + j] == 0:
                return False

    return True


def mark(y, x, sz, v):
    for i in range(sz):
        for j in range(sz):
            board[y + i][x + j] = v
    if v:
        paper[sz] -= 1
    else:
        paper[sz] += 1


def backtracking(y, x):
    global ans
    if y == 10:
        ans = min(ans, sum(paper))
        return

    if x == 10:
        backtracking(y + 1, 0)
        return

    if board[y][x] == 0:
        backtracking(y, x + 1)
        return

    for sz in range(1, 6):
        if is_possible(y, x, sz):
            mark(y, x, sz, 0)
            backtracking(y, x + 1)
            mark(y, x, sz, 1)  # 원상복구


backtracking(0, 0)
print(ans if ans != 25 else -1)
