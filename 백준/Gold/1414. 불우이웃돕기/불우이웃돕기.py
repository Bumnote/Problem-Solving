from sys import stdin

input = stdin.readline


def find(x):
    if uf[x] != x:
        uf[x] = find(uf[x])
    return uf[x]


def union(x, y):
    x_root, y_root = find(x), find(y)

    # 이미 같은 집합에 속해있다면 -> return
    if x_root == y_root:
        return

    if x_root > y_root:
        x_root, y_root = y_root, x_root

    uf[y_root] = x_root  # 더 작은 수를 대표 노드로 설정


n = int(input().rstrip())  # n: 방의 개수
edges = []
total = 0
MAP = []
for i in range(n):
    MAP.append(list(input().rstrip()))
    for j in range(n):
        # 0인 경우 -> 연결 가능한 랜선이 없음을 의미한다.
        if MAP[i][j] == '0':
            continue
        elif 'a' <= MAP[i][j] <= 'z':
            MAP[i][j] = ord(MAP[i][j]) - 96
        else:
            MAP[i][j] = ord(MAP[i][j]) - 65 + 27

        edges.append((MAP[i][j], i, j))
        total += MAP[i][j]

# n개의 방에 있는 n개의 컴퓨터를 모두 랜선으로 연결 -> 크루스칼 알고리즘 활용
edges.sort()  # 가중치를 기준으로 오름차순 정렬 -> O(NlogN)
uf = [i for i in range(n)]

SUM = 0
for cost, x, y in edges:
    # 두 Root 노드가 서로 다르다면 -> union()
    if find(x) != find(y):
        SUM += cost
        union(x, y)  # 두 노드를 연결
    # 두 Root 노드가 서로 같다면 -> cycle이 생긴 것으로 continue
    else:
        continue

flag = True
for i in range(n - 1):
    # 대표 노드가 다른 서로 다른 노드가 존재한다면 -> 모두 연결이 안 되어있다는 의미
    if find(uf[i]) != find(uf[i + 1]):
        flag = False
        break

print(total - SUM if flag else -1)
