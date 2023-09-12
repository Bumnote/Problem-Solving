from sys import stdin, maxsize

input = stdin.readline


def dfs(y, x, n_list):
    global MAX, MIN

    if y == n - 1 and x == n - 1:
        temp = n_list[::]  # n_list를 보존하기 위해서 temp변수에 deepcopy
        for i in range(0, len(temp) - 1, 2):
            res = eval("".join(temp[i:i + 3]))
            temp[i + 2] = str(res)

        MAX = max(MAX, int(res))  # 최댓값 갱신
        MIN = min(MIN, int(res))  # 최솟값 갱신
        return

    for dy, dx in ((1, 0), (0, 1)):
        ny, nx = y + dy, x + dx
        # 범위를 넘은 경우 -> 고려하지 않는다.
        if ny < 0 or ny >= n or nx < 0 or nx >= n:
            continue

        visited[ny][nx] = False  # 방문 처리
        n_list.append(MAP[ny][nx])
        dfs(ny, nx, n_list)
        n_list.pop()
        visited[ny][nx] = True  # 복원 처리


n = int(input().strip())  # n: 지도의 크기
MAP = [list(input().split()) for _ in range(n)]

visited = [[True] * n for _ in range(n)]
visited[0][0] = False  # 방문 처리
MAX, MIN = -maxsize, maxsize

dfs(0, 0, [MAP[0][0]])

print(f"{MAX} {MIN}")
