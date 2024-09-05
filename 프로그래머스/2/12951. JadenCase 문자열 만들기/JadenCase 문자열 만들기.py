def solution(s):
    answer = list(s)
    for i in range(1, len(answer)):
        if answer[i-1] == ' ':
            answer[i] = answer[i].upper()
        else:
            answer[i] = answer[i].lower()
    try:
        answer[0] = answer[0].upper()
        return ''.join(answer)
    except:
        return ''.join(answer)