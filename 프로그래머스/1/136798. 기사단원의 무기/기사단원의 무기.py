def solution(number, limit, power):
    num_yacksu = []
    for i in range(1, number+1):
        yack = 0
        for j in range(1, int(i**(1/2))+1):
            if i % j == 0:
                yack += 1
                if (j**2) != i:
                    yack += 1
        if yack > limit:
            num_yacksu.append(power)
        else: num_yacksu.append(yack)
    return sum(num_yacksu)