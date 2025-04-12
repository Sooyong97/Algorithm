#include <stdio.h>

int max(int x, int y) {
    return x > y ? x : y;
}

void checkTri(int a, int b, int c) {
    int sum = a + b + c;
    int maxSide = max(a, max(b, c));

    if (sum - maxSide <= maxSide) {
        printf("Invalid\n");
    }
    else {
        if (a == b && b == c) printf("Equilateral\n");
        else if (a == b || b == c || c == a) printf("Isosceles\n");
        else printf("Scalene\n");
    }
}

int main() {
    int a, b, c;

    while (1) {
        scanf("%d %d %d", &a, &b, &c);
        if (a == 0 && b == 0 & c == 0) return 0;
        checkTri(a, b, c);
    }
}