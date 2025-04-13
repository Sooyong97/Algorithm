#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int main() {
    int N;
    scanf("%d", &N);

    int* arr = malloc(sizeof(int) * N);
    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }

    qsort(arr, N, sizeof(int), compare);
    for (int i = 0; i < N; i++) {
        printf("%d\n", arr[i]);
    }

    free(arr);
    return 0;
}