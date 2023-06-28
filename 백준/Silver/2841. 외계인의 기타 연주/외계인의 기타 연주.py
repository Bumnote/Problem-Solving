from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, p = map(int, input().split())  # n: 음의 수, p: 프렛의 수
finger = 0
melody = [[] for _ in range(7)]
for _ in range(n):
    l, r = map(int, input().split())  # l: 줄의 번호, r: 프렛의 번호
    ## 문제 해결 부분 ##
    # 값이 존재하면서 입력받은 프렛의 번호가 더 작다면 -> 손가락 떼기 pop()
    while melody[l] and melody[l][-1] > r:
        melody[l].pop()
        finger += 1

    # 값이 존재하면서 프렛의 번호가 같은 경우 -> continue
    if melody[l] and melody[l][-1] == r:
        continue

    # 값이 존재하지 않거나, 입력받은 프렛의 번호가 가장 크다면 -> 손가락 누르기 append()
    melody[l].append(r)
    finger += 1

print(finger)
