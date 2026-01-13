def solution(survey, choices):
    score_map = { 'R':0, 'T':0, 'C':0, 'F':0, 'J':0, 'M':0, 'A':0, 'N':0 }
    
    for s, c in zip(survey, choices):
        if c < 4:
            score_map[s[0]] += (4 - c)
        elif c > 4:
            score_map[s[1]] += (c - 4)
            
    indicators = [("R", "T"), ("C", "F"), ("J", "M"), ("A", "N")]
    answer = ""
    
    for type1, type2 in indicators:
        if score_map[type1] >= score_map[type2]:
            answer += type1
        else:
            answer += type2
            
    return answer