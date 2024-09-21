def solution(s, n):
    s = list(s)
    answer = ""
    for i in s:
        if i == " ":
            answer += i
        else:
            if (ord(i)+n) > 122 or (ord(i)<91 and (ord(i)+n) > 90):
                answer += chr(ord(i)+n-26)
            else:
                answer += chr(ord(i)+n)
    return answer