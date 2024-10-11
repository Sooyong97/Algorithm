def con(char):
    if char == 'w':
        return 1
    elif char == 's':
        return -1
    elif char == 'd':
        return 10
    elif char == 'a':
        return -10
    
def solution(n, control):
    for cont in control:
        n += con(cont)
    return n