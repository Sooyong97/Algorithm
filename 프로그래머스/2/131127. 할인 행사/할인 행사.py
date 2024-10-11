def solution(want, number, discount):
    discount_days = []
    want_list = []
    answer = 0
    for i in range(len(want)):
        for j in range(number[i]):
            want_list.append(want[i])
    for i in range(len(discount)-9):
        discount_days = discount[i:i+10]
        if sorted(want_list) == sorted(discount_days):
            answer += 1
    return answer