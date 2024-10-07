def solution(myString):
    answer = myString.split('x')
    answer.sort()
    while "" in answer:
        answer.remove("")
    return answer