from sys import stdin
from collections import deque

input = stdin.readline

T = int(input().strip())  # T: 테스트 케이스


def bfs(A, B):
    visited = [-1] * 10_000
    command = [""] * 10_000
    dq = deque()
    dq.append(A)
    visited[A] = "*"

    while dq:
        cur_A = dq.popleft()

        #  레지스터의 초기값이 주어진 최종값이 되었다면 -> 과정 출력
        if cur_A == B:
            ans = []
            while True:
                if cur_A == A:
                    # 과정을 역순으로 출력 -> return
                    print(*ans[::-1], sep="")
                    return
                ans.append(command[cur_A])  # 이전의 사용한 명령어들을 저장
                cur_A = visited[cur_A]  # 현재 값을 이전 값으로 변경ㄴ

        D_A = (cur_A * 2) % 10_000 if cur_A * 2 > 9999 else cur_A * 2
        S_A = 9999 if cur_A == 0 else cur_A - 1
        L_A = (cur_A % 1000) * 10 + (cur_A // 1000)
        R_A = (cur_A % 10) * 1000 + (cur_A // 10)

        for nxt, c in ((D_A, "D"), (S_A, "S"), (L_A, "L"), (R_A, "R")):
            # 범위를 넘지 않고, 방문한 적이 없다면 -> 다음 숫자로 이동
            if 0 <= nxt <= 10_000 and visited[nxt] == -1:
                visited[nxt] = cur_A  # 다음 숫자 위치에 현재 숫자를 저장
                command[nxt] = c  # 다음 숫자의 사용한 커맨드를 입력
                dq.append(nxt)

    return


for _ in range(T):
    A, B = map(int, input().split())

    bfs(A, B)
