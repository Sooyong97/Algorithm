def solution(a, b, n):
    answer = 0
    rem_cola = 0
    get_cola = 0
    while True:
        rem_cola = n % a
        get_cola = (n // a) * b
        n = get_cola + rem_cola
        answer += get_cola
        if n < a:
            return answer