from sys import stdin

input = stdin.readline
N = int(input().strip())  # N: 도시의 개수
cities = [list(map(int, input().split())) for _ in range(N)]

for elem in cities:
    print(*elem)
print()
for k in range(N):
    for i in range(N):
        for j in range(N):
            if cities[i][j] > cities[i][k] + cities[k][j]:
                cities[i][j] = cities[i][k] + cities[k][j]
