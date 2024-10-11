def solution(food):
    answer = '0'
    food_list = ''
    food_cal = 1
    for i in food[1:]:
        for j in range(i//2):
            food_list += str(food_cal)
        food_cal += 1
    answer = food_list + answer
    answer += food_list[::-1]
    return answer