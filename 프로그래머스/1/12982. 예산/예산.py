def solution(d, budget):
    answer = 0
    d.sort()
    for i in d:
        if budget - i < 0:
            continue
        else:
            budget -= i
            answer += 1
    return answer