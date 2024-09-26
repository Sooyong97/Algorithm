def solution(a, b):
    if a % 2:
        if b % 2:
            return (a**2) + (b**2)
        else:
            return 2*(a + b)
    else:
        if b % 2:
            return 2*(a + b)
        else:
            return abs(a - b)