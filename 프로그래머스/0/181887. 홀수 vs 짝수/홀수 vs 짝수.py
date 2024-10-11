def solution(num_list):
    sum_odd, sum_even = 0, 0
    for i, j in enumerate(num_list, 1):
        if i % 2:
            sum_odd += j
        else: sum_even += j
    return max(sum_odd, sum_even)