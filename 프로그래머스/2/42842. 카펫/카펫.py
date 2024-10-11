def solution(brown, yellow):
    x, y = 3, 3
    while True:
        if (brown == 2*x + 2*y -4) and (brown + yellow == x*y):
            return [x,y]
        if x == y:
            x += 1
            y = 3
        elif x > y:
            y += 1