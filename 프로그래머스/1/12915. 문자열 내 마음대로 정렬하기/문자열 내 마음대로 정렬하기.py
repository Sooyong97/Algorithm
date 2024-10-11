def solution(strings, n):
    answer = []
    dic = {}
    for i in strings:
        dic[i] = i[n]
    dic_sorted = dict(sorted(dic.items(), key = lambda item: item[0]))
    dic_sorted = dict(sorted(dic_sorted.items(), key = lambda item: item[1]))
    for i in dic_sorted.items():
        answer.append(i[0])
    return answer