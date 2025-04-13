#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int main() {
    int arr[5];
    int sum = 0;
    for (int i = 0; i < 5; i++) {
        scanf("%d", &arr[i]);
        sum += arr[i];
    }

    int med, mid;
    
    qsort(arr, 5, sizeof(int), compare);
    med = arr[2];
    mid = sum / 5;

    printf("%d\n%d", mid, med);
    
    return 0;
}