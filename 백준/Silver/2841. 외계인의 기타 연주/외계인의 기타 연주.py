from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, p = map(int, input().split())  # n: 음의 수, p: 프렛의 수
finger = 0
melody = [[] for _ in range(7)]
for _ in range(n):
    l, r = map(int, input().split())  # l: 줄의 번호, r: 프렛의 번호
    ## 문제 해결 부분 ##
    # 현재 스택이 비어있거나, 마지막 프렛의 번호보다 크다면 -> 손가락을 누른 채로 프렛을 누른다.
    if not melody[l] or melody[l][-1] < r:
        melody[l].append(r)
        finger += 1
    # 스택이 비어있지 않으면서, 마지막 프렛의 번호보다 작다면 -> 손가락을 교체
    elif melody[l][-1] > r:
        # 마지막 값이 주어진 프랫의 번호보다 큰 경우에만 while문 적용
        while melody[l][-1] > r:
            temp = melody[l].pop()
            finger += 1  # 손가락을 뗐으므로 횟수 증가
            # 존재하는 프랫 번호들보다, 더 낮은 프랫 번호라면 탈출
            if not melody[l]:
                break

        # 존재하는 프랫 번호들보다, 더 낮은 프랫 번호라면 리스트에 추가
        if not melody[l]:
            melody[l].append(r)
            finger += 1
        # 마지막 값이 같다면, 누른 상태 유지
        else:
            if melody[l][-1] != r:
                melody[l].append(r)
                finger += 1  # 손가락을 뗐으므로, 해당 프렛의 번호를 눌러야한다.

    # 스택이 비어있지 않고, 마지막 프렛의 번호와 같다면 -> 누른 채로 유지
    else:
        continue

print(finger)
