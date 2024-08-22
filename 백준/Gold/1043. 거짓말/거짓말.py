from sys import stdin

input = stdin.readline


def find(x):
    if uf[x] != x:
        uf[x] = find(uf[x])  # 경로 압축
    return uf[x]


def union(x, y):
    x_root, y_root = find(x), find(y)

    # root가 같으면 -> 이미 같은 집합
    if x_root == y_root:
        return

    if x_root > y_root:
        x_root, y_root = y_root, x_root

    uf[y_root] = x_root  # 더 작은 root를 노드로 삼는다.


n, m = map(int, input().split())
trueCnt, *true = map(int, input().split())
uf = [i for i in range(n + 1)]

# 진실을 아는 사람의 root를 0번 노드로 설정
for i in range(trueCnt):
    uf[true[i]] = 0

parties = []
for _ in range(m):
    cnt, *persons = map(int, input().split())
    parties.append(persons)
    for i in range(cnt - 1):
        union(persons[i], persons[i + 1])  # 각 파티 인원들마다 합집합 연산을 해준다.

cnt = 0
for party in parties:
    flag = True
    for person in party:
        if find(person) == 0:
            flag = False

    if flag:
        cnt += 1

print(cnt)
