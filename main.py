from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n_list = [list(map(str, input().split())) for _ in range(5)]
n_set = set() # 중복 제거를 위해서 set 자료형 선언


## 문제 해결 부분 ##
def dfs(y, x, cnt, s):
    # 6 자리의 문자열을 만들었다면 -> set에 추가 후 return
    if cnt == 6:
        n_set.add(s)
        return

    for dy, dx in ((-1, 0), (1, 0), (0, 1), (0, -1)):
        new_y, new_x = y + dy, x + dx,
        if new_y < 0 or new_y >= 5 or new_x < 0 or new_x >= 5:
            continue
        dfs(new_y, new_x, cnt + 1, s + n_list[new_y][new_x])


for y in range(5):
    for x in range(5):
        dfs(y, x, 0, "")  # 깊이 우선 탐색

print(len(n_set))
