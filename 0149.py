aw, ab = map(int, input().split())
bw, bb = map(int, input().split())
c, d = map(int, input().split())

# a --> b 可能な限り黒色を渡す
if c <= ab:
    ab -= c
    bb += c
else:
    x, y = ab, c - ab
    ab -= x
    bb += x
    aw -= y
    bw += y

# b --> a 可能な限り白色を渡す
if d <= bw:
    bw -= d
    aw += d
else:
    x, y = bw, d - bw
    ab += y
    bb -= y
    aw += x
    bw -= x
    
print(aw)