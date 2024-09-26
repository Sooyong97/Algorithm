def solution(score):
    score_avg = [(sum(i)/len(i)) for i in score]
    score_avg_sorted = sorted(score_avg, reverse = True)
    answer = [score_avg_sorted.index(i) + 1 for i in score_avg]
    return answer