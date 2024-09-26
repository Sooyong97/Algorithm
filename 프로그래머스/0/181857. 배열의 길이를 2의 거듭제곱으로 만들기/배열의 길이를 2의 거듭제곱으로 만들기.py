import math
def solution(arr):
    a = int(math.log2(len(arr)))
    if len(arr) > 2**a:
        for i in range((2**(a+1))-len(arr)):
            arr.append(0)
    return arr