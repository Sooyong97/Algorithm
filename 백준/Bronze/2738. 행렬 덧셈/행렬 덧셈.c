#include <stdio.h>

int main() {
    int n = 0, m = 0, num = 0;
    scanf("%d %d", &n, &m);

    int result[n][m];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%d", &num);
            result[i][j] = num;
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%d", &num);
            result[i][j] += num;
            printf("%d ", result[i][j]);
        }
        printf("\n");
    }
    return 0;
}