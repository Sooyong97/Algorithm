def solution(num):
    count = 0
    while True:
        if num % 2 == 0:
            num /= 2
            count += 1
            if num == 1:
                return count
            if count == 500:
                return -1
        else:
            if num == 1:
                return 0
            num = num * 3 + 1
            count += 1
            if count == 500:
                return -1