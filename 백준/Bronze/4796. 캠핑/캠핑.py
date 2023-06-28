from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
tc = 0
while True:
    tc += 1
    L, P, V = map(int, input().split())  # P일 중, L일 동안, V일 짜리 휴가 (1 < L < P < V)
    if L + P + V == 0:
        break

    ## 문제 해결 부분 ##
    answer = (V // P) * L + (L if (V % P) > L else (V % P))
    print(f"Case {tc}: {answer}")
