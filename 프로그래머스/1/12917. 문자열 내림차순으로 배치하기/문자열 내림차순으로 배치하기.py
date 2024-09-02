def solution(s):
    answer = ''
    ints = []
    for i in s:
        ints.append(ord(i))
    ints.sort(reverse=True)
    for i in ints:
        answer += chr(i)
    return answer