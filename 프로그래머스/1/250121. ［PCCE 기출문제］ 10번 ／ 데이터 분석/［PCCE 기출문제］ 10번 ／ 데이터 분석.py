def solution(data, ext, val_ext, sort_by):
    answer = []
    
    n = mapping(ext)
    
    for arr in data:
        if arr[n] < val_ext:
            answer.append(arr)
    answer.sort(key=lambda x : x[mapping(sort_by)])
    return answer

def mapping(key):
    dic = {
        'code' : 0,
        'date' : 1,
        'maximum' : 2,
        'remain' : 3
    }
    
    return dic[key]