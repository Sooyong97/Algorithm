def solution(array, commands):
    answer = []
    for i in commands:
        array_copy = array.copy()
        array_copy = array_copy[i[0]-1:i[1]]
        array_copy.sort()
        answer.append(array_copy[i[2]-1])
    return answer