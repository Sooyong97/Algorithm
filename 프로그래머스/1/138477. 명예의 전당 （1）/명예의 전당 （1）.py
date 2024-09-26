def solution(k, score):
    best_score, answer = [], []
    
    for i in score:
        if len(best_score) < k:
            best_score.append(i)
        else:
            if min(best_score) < i:
                best_score.remove(min(best_score))
                best_score.append(i)
        answer.append(min(best_score))
    
    return answer