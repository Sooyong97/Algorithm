def solution(dartResult):
    scores = []
    i = 0

    while i < len(dartResult):
        # 점수 계산
        if dartResult[i].isdigit():
            if i + 1 < len(dartResult) and dartResult[i + 1].isdigit():
                score = int(dartResult[i:i + 2])  # 10 점수 처리
                i += 2
            else:
                score = int(dartResult[i])  # 1~9 점수 처리
                i += 1

            # 보너스 처리
            if dartResult[i] == 'S':
                score = score ** 1
            elif dartResult[i] == 'D':
                score = score ** 2
            elif dartResult[i] == 'T':
                score = score ** 3
            i += 1

            # 옵션 처리
            if i < len(dartResult) and (dartResult[i] == '*' or dartResult[i] == '#'):
                if dartResult[i] == '*':
                    score *= 2
                    if scores:
                        scores[-1] *= 2  # 이전 점수도 2배
                elif dartResult[i] == '#':
                    score *= -1
                i += 1
            
            scores.append(score)

    return sum(scores)