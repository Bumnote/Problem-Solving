from sys import stdin

input = stdin.readline


def find(x):
    if uf[x] == x:
        return x

    uf[x] = find(uf[x])
    return uf[x]


def union(a, b):
    a, b = find(a), find(b)
    uf[a] = b


n, m, k = map(int, input().split())  # n: 학생 수, m: 친구 관계 수, k: 가지고 있는 돈

money = [0] + list(map(int, input().split()))  # money: 각각의 학생이 원하는 친구비
uf = [i for i in range(n + 1)]  # union-find list
vertex = [[] for _ in range(n + 1)]

for _ in range(m):
    v, w = map(int, input().split())  # v <-> w: 친구
    union(v, w)

# 대표 노드와 연결된 모든 노드에 해당하는 친구비를 append
for j in range(1, n + 1):
    index = find(j)  # 갱신이 안된 관계를 위해서 find(j)로 값 저장
    vertex[index].append(money[j])

ans = 0
for t in range(1, n + 1):
    # 원소가 하나라도 있다면 -> 가장 작은 친구비를 더한다.
    if vertex[t]:
        ans += min(vertex[t])

# 가진 돈으로 모든 친구를 사귈 수 있다면 -> 최소비용 출력
if ans <= k:
    print(ans)
# 가진 돈으로 모든 친구를 사귈 수 없다면 -> "Oh no" 출력
else:
    print("Oh no")
