def solution(picture, k):
    answer = []
    for i in picture:
        str1 = ''
        for j in i:
            str1 += j*k
        for ii in range(k):
            answer.append(str1)
    return answer