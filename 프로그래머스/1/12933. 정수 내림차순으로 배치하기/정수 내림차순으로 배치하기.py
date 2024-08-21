def solution(n):
    nlist = ''.join(sorted(str(n), reverse=True))
    return int(nlist)