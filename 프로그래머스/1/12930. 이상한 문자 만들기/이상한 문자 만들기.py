def solution(s):
    answer = ''
    s = list(s)
    j = 0
    for i in s:
        if i == ' ':
            answer += i
            j = 0
            continue
        elif j % 2 == 0:
            i = i.upper()
        else: i = i.lower()
        answer += i
        j += 1
    return answer