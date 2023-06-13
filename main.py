from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
r, c, k = map(int, input().split())  # r: 행, c: 열, k: 거리
h_map = [list(input().strip()) for _ in range(r)]


## 문제 해결 부분 ##
## 왼쪽 아래(현수) ----> 오른쪽 위(집)
def dfs(y, x, k):
    global cnt, answer

    # 현수가 집에 도착한 경우 -> answer++
    if y == 0 and x == c - 1 and cnt == k - 1:
        answer += 1
        return

    for dy, dx in ((-1, 0), (0, 1), (1, 0), (0, -1)):
        new_y, new_x = y + dy, x + dx

        if new_y < 0 or new_y >= r or new_x < 0 or new_x >= c or not visited[new_y][new_x] or h_map[new_y][
            new_x] == "T":
            continue
        visited[new_y][new_x] = False  # 방문 처리
        cnt += 1
        dfs(new_y, new_x, k)
        cnt -= 1
        visited[new_y][new_x] = True  # 복원 처리


visited = [[True] * c for _ in range(r)]  # 방문 확인용
cnt, answer = 0, 0
visited[r - 1][0] = False  # 현수의 위치 -> 방문처리
dfs(r - 1, 0, k)

print(answer)
