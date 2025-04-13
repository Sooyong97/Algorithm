#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int binary_search(int* arr, int size, int target) {
    int left = 0, right = size - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}

int main() {

    int n;
    scanf("%d", &n);
    int* input = malloc(sizeof(int) * n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &input[i]);
    }

    int* temp = malloc(sizeof(int) * n);
    for (int i = 0; i < n; i++) {
        temp[i] = input[i];
    }

    qsort(temp, n, sizeof(int), compare);

    int* unique = malloc(sizeof(int) * n);
    int unique_len = 0;
    unique[unique_len++] = temp[0];
    for (int i = 1; i < n; i++) {
        if (temp[i] != temp[i - 1]) {
            unique[unique_len++] = temp[i];
        }
    }

    for (int i = 0; i < n; i++) {
        int idx = binary_search(unique, unique_len, input[i]);
        printf("%d ", idx);
    }
    
    free(input);
    free(temp);
    free(unique);
    return 0;
}