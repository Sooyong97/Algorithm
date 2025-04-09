#include <stdio.h>

int main() {
    int map[9][9];
    int maxNum = 0;
    int x = 0, y = 0;

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            scanf("%d", &map[i][j]);

            if (map[i][j] > maxNum) {
                maxNum = map[i][j];
                x = i;
                y = j;
            }
        }
    }

    printf("%d\n", maxNum);
    printf("%d %d\n", x + 1, y + 1);

    return 0;
}