from sys import stdin

input = stdin.readline

total = 0
n_list = [int(input().strip()) for _ in range(8)]

ans = []
for i, n in enumerate(n_list, start=1):
    ans.append((n, i))

ans = (sorted(ans, reverse=True)[:5])
ans.sort(key=lambda x: x[1])
nums = []
for elem, index in ans:
    total += elem
    nums.append(index)

print(total)
print(*nums)
