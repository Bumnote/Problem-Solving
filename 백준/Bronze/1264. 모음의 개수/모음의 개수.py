from sys import stdin 

input = stdin.readline

while True:
	s = input().strip()
	if s == "#":
		break 
	answer = 0 
	for i in range(len(s)):
		if s[i] == "a" or s[i] == "e" or s[i] == "i" or s[i] == "o" or s[i] == "u":
			answer += 1
		if s[i] == "A" or s[i] == "E" or s[i] == "I" or s[i] == "O" or s[i] == "U":
			answer += 1
	print(answer)