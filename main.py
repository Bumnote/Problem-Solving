from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
d, k = map(int, input().split())  # d: 할머니가 넘어온 날, k: 호랑이에게 준 떡 개수


## 문제 해결 부분 ##
def solve(d, k):
    # d-1일 때 떡의 개수를 k부터 1씩 감소시키며 브루트포스 탐색
    for i in range(k, 0, -1):
        a, b = i, k
        flag = True  # 문제의 조건에 만족하는 경우, True 값이 유지된다.

        # d-1, d 값을 검색하므로, 첫째 날과 둘째 날은 d-2번 반복하면 구할 수 있다.
        for j in range(d - 2):
            a, b = b - a, a
            # 수의 크기가 역전되거나, 1보다 작아지게 되면 -> False 처리
            if a > b or a < 1:
                flag = False
                break
        # 위 if 조건문에 걸리지 않고, 잘 통과했다면 return
        if flag:
            return [a, b]


print(*solve(d, k), sep="\n")
