def solution(numbers):
    answer = 0
    for i in range(10):
        try:
            numbers.index(i)
        except ValueError:
            answer += i
    return answer