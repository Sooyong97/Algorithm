def solution(n):
    num1 = list(bin(n)).count('1')
    while True:
        n += 1
        if list(bin(n)).count('1') == num1:
            return n