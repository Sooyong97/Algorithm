def solution(n):
    n3 = ''
    answer = 0
    while n > 0:
        n3 += str(n%3)
        n //= 3
    n3 = list(n3)
    n3.reverse()
    j = 1
    for i in n3:
        answer += int(i) * j
        j *= 3
    return answer