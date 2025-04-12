#include <stdio.h>

int max(int x, int y) {
    return x > y ? x : y;
}

int main() {
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);
    int sum = a + b + c;
    int maxVal = max(a, max(b, c));
    sum -= maxVal;
    while (1) {
        if (sum > maxVal) break;
        maxVal--;
    }
    sum += maxVal;

    printf("%d", sum);
    return 0;
}