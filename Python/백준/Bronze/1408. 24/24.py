from sys import stdin

input = stdin.readline

ch, cm, cs = map(int, input().split(":"))
fh, fm, fs = map(int, input().split(":"))

h, m, s = None, None, None
curr = ch * 60 * 60 + cm * 60 + cs
future = 24 * 60 * 60 + fh * 60 * 60 + fm * 60 + fs

remain = future - curr
s = remain % 60
remain //= 60
m = remain % 60
remain //= 60
h = remain % 24

print(f"{h:02}:{m:02}:{s:02}")
