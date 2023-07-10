from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
xs, ys = map(int, input().split())  # (xs, ys): 수빈이 위치
xe, ye = map(int, input().split())  # (xe, ye): 집의 위치
for _ in range(3):
    x1, y1, x2, y2 = map(int, input().split())  # (x1, y1) <-> (x2, y2)
