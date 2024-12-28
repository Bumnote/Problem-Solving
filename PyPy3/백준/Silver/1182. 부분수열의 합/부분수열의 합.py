from sys import stdin

input = stdin.readline


def bt(lst, total):
    global cnt

    # 크기가 양수이면서, 더한 값이 s가 되는 경우 -> cnt++
    if lst and total == s:
        cnt += 1

    for i in range(n):
        # 원소가 있고, 인덱스가 내림차순인 경우 -> 유망하지 않으므로 continue
        if lst and lst[-1] >= i:
            continue

        if not visited[i]:
            visited[i] = True  # 방문 처리
            lst.append(i)
            bt(lst, total + n_lst[i])
            lst.pop()
            visited[i] = False  # 복원 처리


n, s = map(int, input().split())
n_lst = list(map(int, input().split()))

cnt = 0
visited = [False for _ in range(n)]
bt([], 0)

print(cnt)
