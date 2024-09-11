from sys import stdin

input = stdin.readline

n = int(input().rstrip())  # n: 수열의 길이
lst = list(map(int, input().split()))

drt = True  # True: 증가 방향 / False # 감소 방향
ans = True
for i in range(n - 1):
    # 높이가 같다면 -> break
    if lst[i] == lst[i + 1]:
        ans = False
        break

    # 증가하는 방향이지만, 다음 수가 더 작다면 -> 방향 전환
    if drt and lst[i] > lst[i + 1]:
        drt = False
    # 감소하는 방향이지만, 다음 수가 더 크다면 -> break
    elif not drt and lst[i] < lst[i + 1]:
        ans = False
        break

print("YES" if ans else "NO")
