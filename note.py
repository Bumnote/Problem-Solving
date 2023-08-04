from sys import stdin
from collections import deque

input = stdin.readline

T = int(input().strip())  # T: 테스트 케이스

for _ in range(T):
    N = int(input().strip())  # N: 카드의 개수
    N_list = deque((input().split()))

    answer = N_list.popleft()

    while N_list:
        temp = N_list.popleft()
        # 가장 첫번째 있는 숫자보다 사전순으로 빠르다면 -> 앞에 append
        if ord(temp) <= ord(answer[0]):
            answer = temp + answer
        # 가장 첫번째 있는 숫자보다 사전으로 느리다면 -> 뒤에 append
        else:
            answer = answer + temp

    print(answer)
