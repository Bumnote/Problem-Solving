tc = int(input())  # 테스트 케이스

for t in range(1, tc + 1):
    ## 변수 입력 부분 ##
    n, m = map(int, input().split())  # n x n 배열, m x m 파리채
    grid = [list(map(int, input().split())) for _ in range(n)]
    answer = 0
    Sum = 0  # 파리채 영역마다 죽은 파리 수

    ## 문제 해결 부분 ##
    # n x n 배열에서 m x m 배열을 탐색
    for y in range(n - m + 1):
        for x in range(n - m + 1):
            # 해당 위치에서 m x m 배열을 탐색
            for z in range(m):
                for w in range(m):
                    Sum += grid[y + z][x + w]
            if answer < Sum:
                answer = Sum
            Sum = 0  # 초기화 

    print(f"#{t} {answer}")