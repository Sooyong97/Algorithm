def solution(n):
    answer = 0
    for i in range(1, n+1):
        k = 0
        for j in range(i,n+1):
            k += j
            if k == n:
                answer += 1
            elif k > n:
                break
            
    return answer