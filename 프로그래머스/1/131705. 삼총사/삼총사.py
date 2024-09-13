def solution(number):
    answer = 0
    a, b = [], []
    a = number.copy()
    for i in number:
        a.remove(i)
        for j in a:
            b = a.copy()
            b.remove(j)
            for k in b:
                if i + j + k == 0:
                    print(i, j, k)
                    answer += 1
    return answer/2