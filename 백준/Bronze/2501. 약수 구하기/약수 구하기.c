#include <stdio.h>

int main() {

    int N, K;

    scanf("%d %d", &N, &K);

    int count = 0;
    for (int i = 1; i <= N; i++) {
        if (N % i == 0) count++;
        if (count == K) {
            printf("%d", i);
            return 0;
        }
    }

    printf("0");
    return 0;
}