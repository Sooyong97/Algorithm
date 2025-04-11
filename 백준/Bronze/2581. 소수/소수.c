#include <stdio.h>

int isPrime(int num) {
    if (num < 2) return 0;
    for (int i = 2; i < num; i++) {
        if (num % i == 0) return 0;
    }
    return 1;
}

int main() {
    int M, N;
    scanf("%d", &M); scanf("%d", &N);

    int sum = 0, minValue = -1;
    for (int i = M; i <= N; i++) {
        if (isPrime(i)) {
            sum += i;
            if (minValue == -1) minValue = i;
        }
    }

    if (sum == 0) {
        printf("-1");
    }
    if (sum != 0) {
        printf("%d\n%d", sum, minValue);
    }
    return 0;
}