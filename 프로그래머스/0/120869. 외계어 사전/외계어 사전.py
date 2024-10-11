def solution(spell, dic):
    for i in dic:
        ii = i
        for j in spell:
            if j in ii:
                i = i.replace(j, "", 1)
            else: break
        else:
            if i == "":
                return 1
    return 2