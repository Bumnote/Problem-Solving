from sys import stdin
from collections import deque

input = stdin.readline

t = int(input().rstrip())

for _ in range(t):
    p = input().rstrip()
    n = int(input().rstrip())
    flag = True
    if n >= 1:
        lst = deque(map(int, input().strip().lstrip("[").rstrip("]").split(",")))
        drc = True  # True: 왼쪽, False: 오른쪽
        for func in p:
            # 뒤집는 함수인 경우
            if func == "R":
                if drc:
                    drc = False  # 왼쪽에서 오른쪽으로
                else:
                    drc = True  # 오른쪽에서 왼쪽으로
            # 첫 번째 수를 버리는 함수인 경우
            else:
                # 버려야 하는데 배열이 비어있는 경우 -> error
                if not lst:
                    flag = False
                    break
                    # 버려야할 수가 존재하는 경우 -> pop
                else:
                    # 왼쪽 방향인 경우 -> popleft
                    if drc:
                        lst.popleft()
                    # 오른쪽 방향인 경우 -> pop
                    else:
                        lst.pop()

        if flag:
            # 모든 함수를 적용시킨 경우 -> 결과 출력
            print("[", end="")
            # 방향이 왼쪽부터인 경우
            if drc:
                print(*lst, sep=",", end="")
            # 방향이 오른쪽부터인 경우
            else:
                lst = list(lst)[::-1]
                print(*lst, sep=",", end="")
            print("]")
        else:
            print("error")
    # 원소의 개수가 0개이면서 함수를 적용시켜야 하는 경우 -> error
    else:
        lst = input().strip()
        for func in p:
            if func == "D":
                flag = False
                break

        # 빈 배열이어도 "R"만 있다면 error가 아니다.
        if flag:
            print("[]")
        # D 함수가 하나라도 있으면 error
        else:
            print("error")
