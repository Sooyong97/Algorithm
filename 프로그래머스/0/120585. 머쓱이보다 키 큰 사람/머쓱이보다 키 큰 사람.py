def solution(array, height):
    answer = sum(1 for num in array if num > height)
    return answer