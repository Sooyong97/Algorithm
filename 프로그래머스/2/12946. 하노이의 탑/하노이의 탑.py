def hanoi(n, source, target, auxiliary, answer):
    if n == 1:
        answer.append([source, target])
        return
    hanoi(n - 1, source, auxiliary, target, answer)
    answer.append([source, target])
    hanoi(n - 1, auxiliary, target, source, answer)  

def solution(n):
    answer = []
    hanoi(n, 1, 3, 2, answer)
    return answer