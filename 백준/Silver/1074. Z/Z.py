from sys import stdin

input = stdin.readline


def bt(y, x, n, pos):
    global ans

    if n == 1:
        for i in range(y, y + 2):
            for j in range(x, x + 2):
                if i == r and j == c:
                    ans = pos
                    return
                pos += 1

    flag = (2 ** (n + n)) // 4
    step = 2 ** (n - 1)
    for nxt_y, nxt_x, nxt_pos in ((y, x, pos + 0),
                                  (y, x + step, pos + flag),
                                  (y + step, x, pos + flag * 2),
                                  (y + step, x + step, pos + flag * 3)):
        if nxt_y <= r < nxt_y + step and nxt_x <= c < nxt_x + step:
            bt(nxt_y, nxt_x, n - 1, nxt_pos)


n, r, c = map(int, input().split())
ans = 0

bt(0, 0, n, 0)
print(ans)
