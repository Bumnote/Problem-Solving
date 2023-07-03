from sys import stdin, maxsize

input = stdin.readline

## 변수 입력 부분 ##
tc = int(input().strip())  # tc: 테스트 케이스

for t in range(1, tc + 1):
    s = int(input().strip())  # s: 스테이션의 수
    matrix = [list(map(int, input().strip())) for _ in range(s)]

    for y in range(s):
        for x in range(s):
            if y != x and matrix[y][x] == 0:
                matrix[y][x] = maxsize

    for k in range(s):
        for i in range(s):
            for j in range(s):
                matrix[i][j] = min(matrix[i][j], matrix[i][k] + matrix[k][j])

    ans = 0
    cnt = 0
    for y in range(s):
        for x in range(s):
            if matrix[y][x] == maxsize:
                matrix[y][x] = 0
            # 해당 거리가 더 크다면 -> 거리 갱신, 개수 갱신
            if matrix[y][x] > ans:
                ans = matrix[y][x]
                cnt = 1
            # 해당 거리가 같다면 -> 거리 유지, 개수 증가
            elif matrix[y][x] == ans:
                cnt += 1

    print(f"Case #{t}: {ans * cnt}")  # 출력 형식
