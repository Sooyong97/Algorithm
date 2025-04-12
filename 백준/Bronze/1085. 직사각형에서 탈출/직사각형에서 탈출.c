#include <stdio.h>

int min(int a, int b) {
    return a > b ? b : a;
}

int main() {
    int x, y, w, h;
    scanf("%d %d %d %d", &x, &y, &w, &h);
    
    int xMin = min(x, w - x);
    int yMin = min(y, h - y);
    int result = min(xMin, yMin);

    printf("%d", result);

    return 0;
}