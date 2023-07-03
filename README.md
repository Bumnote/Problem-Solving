## &nbsp;&nbsp;Problem-Solving (Language: Python)
## &nbsp;&nbsp;Sites 
- 백준 -> https://www.acmicpc.net/
- SW Expert Academy -> https://swexpertacademy.com/main/main.do
- 프로그래머스 -> https://programmers.co.kr/
--- 
##           * 실행 시간과 관련하여 *

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

##               * 알아두면 좋은 것들 *

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

##               * 자주 사용하는 라이브러리 정리 * 

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

##               * 자주 사용하는 알고리즘 정리 *

- 유클리드 알고리즘 -> 최대 공약수를 빠르게 찾는 알고리즘

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

- 에라토스테네스의 체 -> 소수(prime)를 빠르게 판별해주는 알고리즘

```Python
n = 1000  # 2부터 1,000까지의 모든 수에 대하여 소수 판별
primes = [False, False] + [True] * (n - 1)  # 처음엔 모든 수가 소수(True)인 것으로 초기화

# 에라토스테네스의 체 알고리즘 
for i in range(2, n):  # 2부터 n 까지의 모든 수를 확인 
    if primes[i] == True:  # i가 소수인 경우 (남은 수인 경우)
        # i를 제외한 i의 모든 배수를 지우기
        j = 2
        while i * j <= n:
            primes[i * j] = False
            j += 1
```

- 제곱근을 이용한 소수 판별

```python
from math import sqrt

def isPrime(n):
    for i in range(2, int(sqrt(n) + 1)):
        if n % i == 0:
            return False

    return True 
```

- 플로이드 워셜 점화식
```python
for k in range(n):
    for i in range(n):
        for j in range(n):
            MAP[i][j] = min(MAP[i][j], MAP[i][k] + MAP[k][j])
```