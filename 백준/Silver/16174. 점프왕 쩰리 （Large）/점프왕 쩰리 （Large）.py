from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n x n MAP
MAP = [list(map(int, input().split())) for _ in range(n)]
visited = [[True] * n for _ in range(n)]  # 방문 확인용


## 문제 해결 부분 ##
def dfs(y, x):
    global flag

    if y == n - 1 and x == n - 1:
        flag = True
        return

    # 해당 MAP에 적힌 숫자만큼 이동한다.
    for dy, dx in ((0, MAP[y][x]), (MAP[y][x], 0)):
        new_y, new_x = dy + y, dx + x
        if new_y >= n or new_x >= n or not visited[new_y][new_x]:
            continue

        visited[new_y][new_x] = False  # 방문 처리
        dfs(new_y, new_x)

    if flag:
        return "HaruHaru"
    else:
        return "Hing"


flag = False
visited[0][0] = False  # 방문 처리
print(dfs(0, 0))
