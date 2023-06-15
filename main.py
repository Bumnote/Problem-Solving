from sys import stdin, setrecursionlimit

input = stdin.readline
setrecursionlimit(10 ** 5)

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 작업 개수, m: 순서 정보
job = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())  # a -> b 단방향 그래프
    job[b].append(a)  # b -> a 로 저장하여 b에서부터 dfs 실행

x = int(input().strip())  # x: 오늘 끝내야 할 작업 번호


## 문제 해결 부분 ##
def dfs(x):
    global cnt

    for elem in job[x]:
        # 방문이 가능하다면 -> 깊이 탐색
        if visited[elem]:
            visited[elem] = False  # 방문 처리
            cnt += 1
            dfs(elem)


visited = [True] * (n + 1)  # 방문 확인용
visited[x] = False  # 방문 처리
cnt = 0
dfs(x)

print(cnt)
