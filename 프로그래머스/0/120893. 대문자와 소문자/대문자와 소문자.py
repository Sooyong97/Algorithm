def solution(my_string):
    answer = ''
    for i in my_string:
        if 64 < ord(i) < 91:
            answer += i.lower()
        elif 96 < ord(i) < 123:
            answer += i.upper()
    return answer