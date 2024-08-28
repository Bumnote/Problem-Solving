from sys import stdin

input = stdin.readline

total, SUM = 0.0, 0.0
grade_value = {"A+": 4.5, "A0": 4.0, "B+": 3.5, "B0": 3.0, "C+": 2.5, "C0": 2.0, "D+": 1.5, "D0": 1.0, "F": 0.0,
               "P": 0.0}
for _ in range(20):
    name, gpa, grade = input().split()
    # 등급이 P인 과목은 계산에서 제외
    if grade == "P":
        continue
    total += float(gpa) * grade_value[grade]
    SUM += float(gpa)

print(f"{total / SUM}")
