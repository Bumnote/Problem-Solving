from sys import stdin

input = stdin.readline

n = int(input().strip())  # 계단의 개수
stairs = [int(input().strip()) for _ in range(n)]  # 각 계단의 점수

dp = [0] * n  # dp 테이블 초기화
dp[0] = stairs[0]
