## &nbsp;&nbsp;Problem-Solving (Language: Python)

## &nbsp;&nbsp;Sites

- 백준 -> https://www.acmicpc.net/
- SW Expert Academy -> https://swexpertacademy.com/main/main.do
- 프로그래머스 -> https://programmers.co.kr/

--- 

##              * 실행 시간과 관련하여 *

```python
# 실행 시간을 빠르게 하는 방법 - 1
dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
for dy, dx in zip(dys, dxs):
    pass
# zip 함수를 사용하는 것보다 아래와 같은 방법이 훨씬 빠르다.
for dy, dx in ((-1, 0), (1, 0), (0, 1), (0, -1)):
    pass

# 실행 시간을 빠르게 하는 방법 - 2
n, m = 10, 10


def in_range(y, x):
    return 0 <= y < n and 0 <= x < m


# 사용자 함수를 이용해서 범위를 판단하는 것보다 아래와 같이 함수를 호출하지 않는 방법이 훨씬 빠르다.
y, x = map(int, input().split())
if (0 <= y < n and 0 <= x < m):
    pass

# 실행 시간을 빠르게 하는 방법 - 2
num_set = set()
# set은 느린 자료구조이다. 따라서 인덱스를 통해서 접근하고자 할 때에는 리스트를 사용하도록 하자.
num_set = []

```

##                  * 알아두면 좋은 것들 *

```Python 
## 문자열을 올바르게 입력받고, 파일의 끝(EOF)을 올바르게 판단하는 법 ## 
from sys import stdin 

input() # EOF를 받을 때, EOF Error를 발생시킨다. -> try-except문 활용!
stdin.readline() # EOF를 받을 때, 빈 문자열을 반환한다. 

# 이 둘은 같지 않다. -> 부동소수점 issue (ex) a: 500, b: 80
# 소수점을 다룰 시, 모든 연산을 수행한 후에 나눗셈 연산을 마지막에 해주자. 
(a * (100 - b)) / 100) != (a * (1 - (b / 100)))

# PyPy3의 setrecursionlimit는 그만큼의 재귀 깊이를 감당할 수 있을만큼의 메모리를 미리 할당받는다.
# 따라서, 적당한 메모리 크기를 계산하여 할당받도록 하자. -> 메모리 초과의 원인
```

##                  * 자주 사용하는 라이브러리 정리 * 

```Python
from collections import deque  # 너비 우선 탐색(= BFS) 구현 시 활용 

# 선언 방식 # 
deq = deque()

from itertools import combinations, permutations

# 사용 방식 # 
n_list = [1, 2, 3, 4]
m = 2
# n_list의 모든 원소들 중에서 m개를 선택만 하는 조합 nCm
for elem in combinations(n_list, m):
    print(elem)

# n_list의 모든 원소들 중에서 m개를 선택하여 순서를 고려하여 정렬하는 nPm
for elem in permutations(n_list, m):
    print(elem)

from sys import stdin, setrecursionlimit

# 사용 방식 # 
input = stdin.readline  # 입력 속도를 보다 빠르게해준다.
setrecursionlimit(10 ** 6)  # 재귀의 깊이의 제한을 늘려준다. 

from math import sqrt, floor, ceil

# 사용 방식 #
n = 5
n = sqrt(n)  # 제곱근 함수 
n = floor(n)  # 내림 함수 
n = ceil(n)  # 올림 함수 
```

##                  * 자주 사용하는 알고리즘 정리 *

- 유클리드 알고리즘 -> 최대 공약수를 빠르게 찾는 알고리즘 O(log n)

```Python
def Euclid_GCD(x, y):
    # 나머지를 구하기 위해서 x가 더 큰 수가 오게끔 해준다. 
    if x < y:
        x, y = y, x

    # 나눠주는 대상이 0이 되면 x가 바로 최대 공약수이므로 return 한다.
    if y == 0:
        return x

    # 재귀적으로 호출한다. 
    return Euclid_GCD(y, x % y)
```

- 에라토스테네스의 체 -> 소수(prime)를 빠르게 판별해주는 알고리즘 O(n log(log n))

```Python
from math import isqrt

n = 1000  # 2부터 1,000까지의 모든 수에 대하여 소수 판별
primes = [False, False] + [True] * (n - 1)  # 처음엔 모든 수가 소수(True)인 것으로 초기화

# 에라토스테네스의 체 알고리즘 (개선 -> 제곱근 활용)
for i in range(2, isqrt(n) + 1):  # 2부터 n 제곱근까지의 수를 확인 
    if not primes[i]:  # i가 소수가 아닌 경우 -> continue 
        continue

    for j in range(2 * i, n + 1, i):
        primes[i] = False  # 소수가 아님을 표시 

"""
* 제곱근까지만 탐색하는 이유
-> N = a * b 인 경우, a != b 일 때, 크기가 더 작은 약수는 N 제곱근을 넘을 수 없다.
-> 또한, N보다 작은 합성수의 경우에도 크기가 더 작은 약수는 N 제곱근보다 클 수 없다.
-> 따라서, N 제곱근까지만 탐색하여도 에라토스테네스의 체를 완성시킬 수 있다.
"""
```

- 플로이드 워셜 점화식 O(n^3)

```python 
for k in range(n):
    for i in range(n):
        for j in range(n):
            MAP[i][j] = min(MAP[i][j], MAP[i][k] + MAP[k][j])
```

- 다익스트라 알고리즘(heapq ver.) 핵심 로직 O(E * logV)

```python
while pq:
    min_dist, cur_v = heappop(pq)  # 거리 기준 최솟값 pop

    # 현 정점까지의 가장 최단 거리(dist[cur_v])가 pop된 거리 정보와 다르다면
    # 같은 정점에 대한 정보가 최신화가 안 되어있는 정보이기 때문에 continue
    # heapq는 최솟값만을 pop하기 때문에 이런 문제가 발생할 수 있다.
    if dist[cur_v] != min_dist:
        continue

    for nxt_v, nxt_dist in vertex[cur_v].items():
        new_dist = dist[cur_v] + nxt_dist  # 다음 정점으로 가는 최단 거리 후보

        # 다음 정점까지 갈 때, 최단거리라고 생각했던 정보보다 더 값이 작으면 -> 갱신
        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist  # 거리 정보 갱신
            heappush(pq, (new_dist, nxt_v))
```

- 다익스트라 알고리즘(for loop ver.) 핵심 로직 O(V * V)

```python
visited = [True] * (n + 1)  # 한번 방문한 정점은 방문하지 않는다.
for i in range(1, n + 1):
    # 거리가 가장 작은 정점을 찾는다. (최초 시 시작 정점)
    temp, cur_v = INF, 0
    for j in range(1, n + 1):
        # 방문이 가능하고, temp값보다 작으면 -> 값과 인덱스 갱신
        if visited[j] and temp > dist[j]:
            temp = dist[j]
            cur_v = j

    # 가장 작은 거리를 가진 정점에 방문
    visited[cur_v] = False  # 방문 처리

    for j in range(1, n + 1):
        # 간선이 존재하지 않는 경우 -> continue
        if vertex[cur_v][j] == 0:
            continue

        # cur_v -> j 간선이 존재하는 경우 -> 필요 시 거리 갱신
        dist[j] = min(dist[j], dist[cur_v] + vertex[cur_v][j])
```

- 이진 탐색 O(log n)

```python
# lower_bound -> target 이상의 값이 최초로 나오는 위치 반환
n_list = []


def lower_bound(target):
    left = 0
    right = len(n_list) - 1
    min_idx = len(n_list)

    while left <= right:
        mid = (left + right) // 2
        # target 이상인 값에서만 위치 갱신
        if target <= n_list[mid]:
            right = mid - 1
            min_idx = min(min_idx, mid)
        else:
            left = mid + 1

    return min_idx


# upper_bound -> target 초과하는 값이 최초로 나오는 위치 반환
def upper_bound(target):
    left = 0
    right = len(n_list) - 1
    min_idx = len(n_list)

    while left <= right:
        mid = (left + right) // 2
        # target 초과한 경우에만 위치 갱신
        if target < n_list[mid]:
            right = mid - 1
            min_idx = min(min_idx, mid)
        else:
            left = mid + 1

    return min_idx
```

- 유니온 파인드(Union-Find) O(log n)

  - Union 연산: 특정 2개의 노드를 연결해 1개의 집합으로 묶는 연산
   
  - Find 연산: 자신이 속한 집합의 대표 노드를 찾아 반환하는 연산
   
  - 경로 압축: 여러 노드를 거쳐야 하는 경로에서 그래프를 변형해 더 짧은 경로로 갈 수 있도록 함으로써 시간 복잡도를 효과적으로 줄이는 방법
   
  - 용도: 여러 개의 노드 무리들이 있을 때, 특정한 2개의 노드를 선택하여 서로 연결되어있는지 확인할 때 
```python
# 대표 노드를 찾아 반환하는 함수 
def find(x):
    if uf[x] == x:
        return x 
    
    uf[x] = find(uf[x])
    return uf[x]


# 두 노드를 연결해주는 함수 
def union(a, b):
    a, b = find(a), find(b)
    uf[a] = b
```
