from sys import stdin

input = stdin.readline


def find(x):
    if uf[x] != x:
        uf[x] = find(uf[x])
    return uf[x]


def union(x, y):
    x_root, y_root = find(x), find(y)
    if x_root == y_root:
        return

    if x_root > y_root:
        x_root, y_root = y_root, x_root

    uf[y_root] = x_root  # 더 작은 노드를 대표 노드로 설정


n, m, k = map(int, input().split())  # n: 학생 수, m: 관계 수, k: 가지고 있는 돈
lst = list(map(int, input().split()))

uf = [i for i in range(n + 1)]
for _ in range(m):
    v, w = map(int, input().split())  # v <-> w: 친구
    if find(v) != find(w):
        union(v, w)  # 친구들끼리 엮는다.

# 각 대표 노드와 연결된 친구 그룹을 형성한다.
dic = {}
for i in range(1, n + 1):
    if find(i) not in dic:
        dic[uf[i]] = [i]
    else:
        dic[uf[i]].append(i)

MAX = 10_000
SUM = 0
# 각 그룹마다 사용할 수 있는 친구비의 최솟값을 구하여 더해준다.
for key in dic.keys():
    money = MAX
    # 각 그룹마다 친구비의 최솟값을 구한다.
    for value in dic[key]:
        money = min(money, lst[value - 1])

    SUM += money  # 각 그룹마다 최소 친구비를 더한다.

print(SUM if SUM <= k else "Oh no")
