from sys import stdin

input = stdin.readline

n, m = map(int, input().split())  # n: 바구니 개수, m: 넣을 공

lst = [0 for _ in range(n + 1)]
for _ in range(m):
    i, j, k = map(int, input().split())  # i번 바구니부터 j번 바구니까지 k번 번호가 적혀져 있는 공을 넣는다.
    for t in range(i, j + 1):
        # 바구니에 공이 없다면 -> k번 공을 넣는다.
        if lst[t] == 0:
            lst[t] = k
        # 바구니에 이미 공이 있다면 -> 기존의 공을 빼고, k번 공을 넣는다.
        else:
            lst[t] = k

print(*lst[1:])
