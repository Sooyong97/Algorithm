#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);
    
    if (N == 1) return 0;

    while (1) {
        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                printf("%d\n", i);
                N /= i;
                break;
            }
        }

        if (N < 2) break;
    }

    return 0;
}