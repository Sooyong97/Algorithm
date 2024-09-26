def solution(cards1, cards2, goal):
    a, b = -1, 0
    goal2 = goal.copy()
    for i in cards1:
        try:
            if a < goal.index(i):
                a = goal.index(i)
                if b != 0: return "No"
                goal2.remove(i)
            elif a > goal.index(i):
                return "No"
        except: b += 1
            
    
    a, b = -1, 0
    for i in cards2:
        try:
            if a < goal.index(i):
                a = goal.index(i)
                if b != 0: return "No"
                goal2.remove(i)
            elif a > goal.index(i):
                return "No"
        except: b += 1
    
    if len(goal2) > 0:
        return "No"
    return "Yes"