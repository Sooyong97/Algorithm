def V(a, b):
    if (a == False) and (b == False):
        return False
    else: return True

def N(a, b):
    if (a == True) and (b == True):
        return True
    else: return False

def solution(x1, x2, x3, x4):
    return N(V(x1,x2), V(x3, x4))