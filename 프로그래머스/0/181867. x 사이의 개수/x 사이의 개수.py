def solution(myString):
    answer = []
    strings = myString.split('x')
    for i in range(len(strings)):
        answer.append(len(strings[i]))
    return answer