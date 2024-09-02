def gcd(n, m):
    if m == 0:
        return n
    else:
        return gcd(m, n%m)

def solution(n, m):
    return [gcd(n,m), gcd(n,m)*(n/gcd(n,m))*(m/gcd(n,m))]