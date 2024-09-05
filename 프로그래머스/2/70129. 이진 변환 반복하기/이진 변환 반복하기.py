def solution(s):
    rm, bi = 0, 0
    while True:
        s = list(s)
        num = []
        for i in s:
            if i == '1':
                num.append(i)
            else:
                rm += 1
        s = format(len(num), 'b')
        bi += 1
        if len(list(s)) == 1:
            break
    return [bi, rm]