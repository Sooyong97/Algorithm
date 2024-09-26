def solution(friends, gifts):
    gift_score, gift_factor, gift_stack = {}, {}, {}
    
    for i in friends:
        if i not in gift_score:
            gift_score[i] = {}
        
        for j in friends:
            if (i != j) and (j not in gift_score[i]):
                gift_score[i][j] = 0
        
        if i not in gift_factor:
            gift_factor[i] = 0
            
        if i not in gift_stack:
            gift_stack[i] = 0

    for i in gifts:
        give, receive = i.split()
        if give not in gift_score:
            gift_score[give] = {}
        if receive not in gift_score[give]:
            gift_score[give][receive] = 0
        gift_score[give][receive] += 1
        gift_factor[give] += 1
        gift_factor[receive] -= 1
    
    for i in friends:
        for j in friends:
            if j != i:
                if gift_score[i][j] > gift_score[j][i]:
                    gift_stack[i] += 1
                elif gift_score[i][j] < gift_score[j][i]:
                    gift_stack[j] += 1
                else:
                    if gift_factor[i] > gift_factor[j]:
                        gift_stack[i] += 1
                    elif gift_factor[i] < gift_factor[j]:
                        gift_stack[j] += 1
        
    return max(gift_stack.values())/2