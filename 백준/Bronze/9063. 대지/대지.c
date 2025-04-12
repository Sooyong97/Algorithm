#include <stdio.h>
#include <stdlib.h>

int min(int x, int y) {
    return x < y ? x : y;
}

int max(int x, int y) {
    return x > y ? x : y;
}

int main() {
    int n;
    scanf("%d", &n);

    int* x = malloc(sizeof(int) * n);
    int* y = malloc(sizeof(int) * n);

    for (int i = 0; i < n; i++) {
        scanf("%d %d", &x[i], &y[i]);
    }

    int xMin = 10000, yMin = 10000, xMax = -10000, yMax = -10000;
    for (int i = 0; i < n; i++) {
        xMin = min(xMin, x[i]);
        xMax = max(xMax, x[i]);
        yMin = min(yMin, y[i]);
        yMax = max(yMax, y[i]);
    }

    if (xMax == xMin || yMax == yMin) {
        printf("0");
    }
    else {
        int area = (xMax - xMin) * (yMax - yMin);
        printf("%d", area);
    }

    free(x);
    free(y);
    return 0;
}