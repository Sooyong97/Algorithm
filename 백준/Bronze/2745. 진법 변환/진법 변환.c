#include <stdio.h>
#include <string.h>

int powInt(int a, int b) {
    int result = 1;
    for (int i = 0; i < b; i++) {
        result *= a;
    }
    return result;
}

void transBtoO(char N[], int B) {
    int len = strlen(N);
    int result = 0;
    for (int i = 0; i < len; i++) {
        if (N[i] == '\0') {
            printf("%d", result);
            return;
        }
        int num = N[i] >= 65 ? N[i] - 55 : N[i] - 48;
        int pos = len - 1 - i;
        result += num * powInt(B, pos);
    }
    printf("%d", result);
}

int main() {
    char N[30] = {0};
    int B = 0;
    scanf("%s %d", N, &B);

    transBtoO(N, B);
}