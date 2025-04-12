#include <stdio.h>

int main() {
    int angleA, angleB, angleC;
    scanf("%d%d%d", &angleA, &angleB, &angleC);

    if (angleA + angleB + angleC != 180) {
        printf("Error\n");
        return 0;
    }

    if (angleA == 60 && angleB == 60 && angleC == 60) {
        printf("Equilateral\n");
    } else if (angleA == angleB || angleB == angleC || angleA == angleC) {
        printf("Isosceles\n");
    } else {
        printf("Scalene\n");
    }

    return 0;
}