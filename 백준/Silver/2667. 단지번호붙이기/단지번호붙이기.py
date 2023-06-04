from sys import stdin

# 1 --> 집이 있는 곳 / 0 --> 집이 없는 곳
# 상하 좌우 검색

def in_range(y, x):
    return 0 <= y < n and 0 <= x < n

def dfs(y, x):
    global person_cnt

    person_cnt += 1
    dys, dxs = [-1,1,0,0], [0,0,-1,1]

    for dy, dx in zip(dys, dxs):
        new_y, new_x = y + dy, x + dx
        if in_range(new_y, new_x) and not visited[new_y][new_x] and grid[new_y][new_x] == 1:
            visited[new_y][new_x] = True
            dfs(new_y, new_x)

n = int(input())
grid = [ list(map(int, stdin.readline().strip())) for _ in range(n) ]
visited = [ [ False for _ in range(n) ] for _ in range(n) ]

person_list = []

for y in range(n):
    for x in range(n):
        if grid[y][x] == 1 and not visited[y][x]:
            visited[y][x] = True 
            person_cnt = 0
            # 깊이 우선 탐색
            dfs(y, x)
            person_list.append(person_cnt)

# 정답 출력
person_list.sort()
print(len(person_list))
for elem in person_list:
    print(elem)