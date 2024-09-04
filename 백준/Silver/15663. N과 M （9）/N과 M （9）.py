from sys import stdin

input = stdin.readline


def bt(cnt, lst):
    if cnt == m:
        # 해당 조합이 셋에 존재하지 않으면 -> 출력 및 저장
        if tuple(lst) not in s:
            print(*lst)
            s.add(tuple(lst))
        return

    for i in range(len(n_list)):
        if canVisit[i]:
            canVisit[i] = False  # 방문 처리
            lst.append(n_list[i])
            bt(cnt + 1, lst)
            canVisit[i] = True  # 복구 처리
            lst.pop()


n, m = map(int, input().split())  # n개의 자연수 중에서 m개를 고른 수열
n_list = sorted(map(int, input().split()))
s = set()  # 조합을 담아둘 set()
canVisit = [True for _ in range(len(n_list))]
bt(0, [])
