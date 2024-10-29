import sys
from cmath import exp, pi
input = sys.stdin.readline

def fft(x):
    n = len(x)
    if n == 1:
        return x
    even_part = fft(x[0::2])
    odd_part = fft(x[1::2])
    w = [exp(2j * pi * k / n) for k in range(n // 2)]
    return [even_part[k] + w[k] * odd_part[k] for k in range(n // 2)] + \
           [even_part[k] - w[k] * odd_part[k] for k in range(n // 2)]

def ifft(x):
    n = len(x)
    if n == 1:
        return x
    even_part = ifft(x[0::2])
    odd_part = ifft(x[1::2])
    w = [exp(-2j * pi * k / n) for k in range(n // 2)]
    return [even_part[k] + w[k] * odd_part[k] for k in range(n // 2)] + \
           [even_part[k] - w[k] * odd_part[k] for k in range(n // 2)]

m = int(input())
n = 2 * m
flag = 0
for i in range(18):
    if m == 2**i:
        flag = -100
        break
    elif n < 2**i:
        flag = i
        break

a = list(map(int, input().split()))
b = list(map(int, input().split()))

if flag == -100:
    a = a + a
    b = b[::-1] + [0] * m
    c = [0] * n
    a_fft = fft(a)
    b_fft = fft(b)
    for i in range(n):
        c[i] = a_fft[i] * b_fft[i]
    c_ifft = ifft(c)
    result = max(round(c_ifft[k].real / n) for k in range(n))
else:
    n_prime = 2**i
    n, n_prime = n_prime, n
    a = a + [0] * (n - n_prime // 2)
    b = b[::-1] + [0] * (n - n_prime) + b[::-1]
    c = [0] * n
    a_fft = fft(a)
    b_fft = fft(b)
    for i in range(n):
        c[i] = a_fft[i] * b_fft[i]
    c_ifft = ifft(c)
    result = max(round(c_ifft[k].real / n) for k in range(n))

print(result)