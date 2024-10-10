def solution(arr):
    answer = []
    x_len = len(arr)
    y_len = len(arr[0])
    if x_len > y_len:
        for i in arr:
            for j in range(x_len-y_len):
                i.append(0)
            answer.append(i)
        return answer
    
    elif y_len > x_len:
        for i in range(y_len-x_len):
            arr.append([0 for j in range(y_len)])
        return arr
    
    else:
        return arr