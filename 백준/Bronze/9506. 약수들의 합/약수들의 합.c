#include <stdio.h>
#include <stdlib.h>

int* findfactors(int n) {
    int* factor = malloc(sizeof(int) * n);
    for (int i = 0; i < n; i++) {
        factor[i] = 0;
    }

    int idx = 0;
    for (int i = 1; i < n; i++) {
        if (n % i == 0) {
            factor[idx] = i;
            idx++;
        }
    }
    return factor;
}

int addFactors(int* factors) {
    int sum = 0;
    for (int i = 0; ; i++) {
        if (factors[i] == 0) break;
        sum += factors[i];
    }
    return sum;
}

int main() {
    
    int n;
    while (1) {
        scanf("%d", &n);
        if (n == -1) break;;

        int* factors = findfactors(n);
        int sum = addFactors(factors);
        if (sum == n) {
            printf("%d =", n);
            for (int i = 0; ; i++) {
                printf(" %d", factors[i]);
                if (factors[i + 1] != 0) printf(" +");
                if (factors[i + 1] == 0) break;
            }
            printf("\n");
        }
        if (sum != n) {
            printf("%d is NOT perfect.\n", n);
        }
        free(factors);
    }

    return 0;
}