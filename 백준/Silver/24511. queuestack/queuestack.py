from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 자료 구조의 개수
A = list(map(int, input().split()))  # 0: 큐, 1: 스택
B_list = list(map(int, input().split()))  # 각 자료 구조에 들어있는 원소
B = []
for i in range(n - 1, - 1, - 1):
    if A[i] == 0:
        B.append(B_list[i])

m = int(input().strip())  # m: 삽입할 수열의 개수
C = list(map(int, input().split()))  # 큐스택에 삽입할 원소 리스트

ans = B + C
print(*ans[:m])
