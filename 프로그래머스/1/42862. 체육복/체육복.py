def solution(n, lost, reserve):
    actual_reserve = set(reserve) - set(lost)
    actual_lost = set(lost) - set(reserve)
    
    for l in sorted(actual_lost):
        if l - 1 in actual_reserve:
            actual_reserve.remove(l - 1)
        elif l + 1 in actual_reserve:
            actual_reserve.remove(l + 1)
        else:
            n -= 1
            
    return n