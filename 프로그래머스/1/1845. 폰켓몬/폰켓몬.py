def solution(nums):
    answer = len(nums)/2
    uni_nums = len(list(set(nums)))
    if uni_nums < answer: answer = uni_nums
    return answer