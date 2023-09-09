from sys import stdin

input = stdin.readline


# 깊이 우선 탐색 구현
def dfs(cur_v):
    for nxt_v in vertex[cur_v]:
        if not person[nxt_v]:
            person[nxt_v] = True  # 진실을 아는 사람으로 저장
            dfs(nxt_v)


n, m = map(int, input().split())  # n: 사람의 수, m: 파티의 수

p, *p_list = map(int, input().split())  # p: 진실을 아는 사람 수, p_list: 사람 리스트
vertex = [[] for _ in range(n + 1)]  # 연결 리스트로 사람들의 관계를 저장

partys = []  # 파티들의 정보를 저장
for _ in range(m):
    i, *i_list = map(int, input().split())  # i: 오는 사람의 수, i_list: 사람 리스트
    partys.append(i_list)  # 파티 정보 저장
    # 원소의 개수가 하나인 경우
    if i == 0:
        vertex[i].append(i)
    # 원소의 개수가 둘 이상인 경우
    else:
        for s in range(i - 1):
            # 양방향으로 관계를 연결리스트에 저장
            vertex[i_list[s]].append(i_list[s + 1])
            vertex[i_list[s + 1]].append(i_list[s])

person = [False] * (n + 1)
for elem in p_list:
    person[elem] = True  # 진실을 아는 사람 처리
    dfs(elem)  # 진실을 아는 사람과 연결된 사람들을 dfs 탐색

ans = m
for party in partys:
    for elem in party:
        # 진실을 아는 사람이 있다면 -> 파티 개수 감소
        if person[elem]:
            ans -= 1
            break

print(ans)
