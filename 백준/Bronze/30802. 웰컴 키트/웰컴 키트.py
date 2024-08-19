from sys import stdin

input = stdin.readline

n = int(input().rstrip())
sizes = list(map(int, input().split()))
t, p = map(int, input().split())  # 티셔츠는 t장씩, 펜은 p자루씩

SUM = 0
for size in sizes:
    # 묶음이 생기지 않고, 낱개인 경우
    if size // t == 0 and size % t != 0:
        SUM += 1
    # 묶음이 생기는 경우
    elif size // t != 0:
        # 묶음으로 딱 떨어지는 경우
        if size % t == 0:
            SUM += (size // t)
        # 묶음으로 묶이면서 낱개가 생기는 경우 
        else:

            SUM += ((size // t) + 1)

print(f"{SUM}")
print(f"{n // p} {n % p}")
