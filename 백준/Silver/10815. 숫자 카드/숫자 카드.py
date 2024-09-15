from sys import stdin

input = stdin.readline

n = int(input().rstrip())  # n: 상근이 숫자의 개수
dic = {num for num in list(map(int, input().split()))}

m = int(input().rstrip())
m_list = list(map(int, input().split()))

for t in m_list:
    print(1 if t in dic else 0, end=" ")
