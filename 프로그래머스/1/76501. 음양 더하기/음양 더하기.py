def solution(absolutes, signs):
    answer = 0
    for i in range(len(absolutes)):
        if signs[i] == False:
            answer += absolutes[i]*-1
        answer += absolutes[i]*signs[i]
    return answer