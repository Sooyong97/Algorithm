from collections import deque

def solution(num_list, n):
    dq = deque(num_list)
    dq.rotate(-n)
    return list(dq)