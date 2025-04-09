#include <stdio.h>

void transOtoB(int N, int B) {
    char result[36];
    int idx = 0;

    while (N > 0) {
        int r = N % B;
        if (r < 10) {
            result[idx++] = '0' + r;
        } else {
            result[idx++] = 'A' + (r - 10);
        }
        N /= B;
    }

    for (int i = idx - 1; i >= 0; i--) {
        printf("%c", result[i]);
    }
    printf("\n");
}

int main() {
    int N = 0, B = 0;
    scanf("%d %d", &N, &B);
    transOtoB(N, B);
    return 0;
}