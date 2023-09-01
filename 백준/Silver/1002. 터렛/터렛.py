from sys import stdin

input = stdin.readline

t = int(input().strip())  # t: 테스크 케이스

for _ in range(t):
    # (x1, y1) -> 조규현의 좌표
    # (x2, y2) -> 백승환의 좌표
    # r1: 조규현이 계산한 류재명과의 거리
    # r2: 백승환이 계산한 류재명과의 거리
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    p_p = (x2 - x1) ** 2 + (y2 - y1) ** 2
    r1_p_r2 = (r1 + r2) ** 2
    r1_m_r2 = abs(r1 - r2) ** 2
    # 조규현과 백승환이 같은 좌표에 있는 경우
    if x1 == x2 and y1 == y2:
        # 있을 수 있는 위치가 0개인 경우
        if r1 != r2:
            print(0)
        # 위치의 개수가 무한대인 경우
        else:
            print(-1)
    # 조규현과 백승환이 다른 좌표에 있는 경우
    else:
        # 교점이 없는 경우
        if p_p > r1_p_r2 or p_p < r1_m_r2:
            print(0)
        # 한 점에서 접하는 경우
        elif p_p == r1_p_r2 or r1_m_r2 == p_p:
            print(1)
        # 두 점에서 만나는 경우
        else:
            print(2)
