def solution(myString, pat):
    answer = ''
    myString = myString[::-1]
    pat = pat[::-1]
    a = 0
    for i in range(len(myString)-len(pat)+1):
        if myString[i:i+len(pat)] == pat:
            a = i
            break
    answer = myString[a:][::-1]
    return answer