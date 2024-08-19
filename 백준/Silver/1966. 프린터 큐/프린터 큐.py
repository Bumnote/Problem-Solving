from sys import stdin
from collections import deque

input = stdin.readline

tc = int(input().rstrip())

for _ in range(tc):
    _, idx = map(int, input().split())
    lst = deque(map(int, input().split()))
    prior = sorted(lst)  # 중요도를 오름차순으로 정렬

    cnt = 0
    while lst:
        # 중요도가 가장 높은 문서가 가장 앞에 있다면 -> 출력한다.
        if lst[0] == prior[-1]:
            prior.pop()  # 출력
            lst.popleft()  # 출력
            cnt += 1  # 출력 횟수 증가
            if idx == 0:
                break

            idx -= 1
        # 가장 앞에 놓인 문서가 중요도가 가장 높지 않다면 -> 가장 맨 뒤로 보낸다.
        else:
            lst.append(lst.popleft())
            # 원하는 문서가 가장 앞에 있는 경우 -> 가장 뒤로 보낸다.
            if idx == 0:
                idx = len(lst) - 1
            # 원하는 문서가 가장 앞에 없는 경우 -> 하나 앞당긴다.
            else:
                idx -= 1

    print(cnt)
