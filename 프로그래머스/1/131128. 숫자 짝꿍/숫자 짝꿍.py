def solution(X, Y):
    answer = ''
    
    for i in range(9, -1, -1):
        count_x = X.count(str(i))
        count_y = Y.count(str(i))
        
        answer += str(i) * min(count_x, count_y)
    
    if not answer:
        return "-1"
    
    if answer[0] == "0":
        return "0"
        
    return answer