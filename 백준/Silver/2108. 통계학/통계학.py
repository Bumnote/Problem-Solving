from sys import stdin

input = stdin.readline

n = int(input().rstrip())  # n: 홀수

nums = [int(input().rstrip()) for _ in range(n)]

# 1. 산술평균
res = f"{sum(nums) / n :.0f}"
print(int(res))

# 2. 중앙값
nums = sorted(nums)
print(nums[n // 2])

# 3. 최빈값
dic = {}
for num in nums:
    if num not in dic:
        dic[num] = 1
    else:
        dic[num] += 1

# 빈도 수를 기준으로 내림차순 정렬
lst = sorted(dic.items(), key=lambda x: (-x[1], x[0]))
res = 0
# 빈도를 가진 숫자가 2개 이상 있는 경우
if len(lst) >= 2:
    if lst[0][1] == lst[1][1]:
        res = lst[1][0]
    else:
        res = lst[0][0]
# 빈도를 가진 숫자가 1개 뿐인 경우
else:
    res = lst[0][0]

print(res)

# 4. 범위
print(abs(nums[-1] - nums[0]))
