#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compare(const void *a, const void *b) {
    return (*(int *)b - *(int *)a);
}

int main() {
    char* input = NULL;
    size_t len = 0;
    ssize_t read;

    read = getline(&input, &len, stdin);
    read--;

    int* arr = (int*)malloc(read * sizeof(int));
    for (int i = 0; i < read; i++) {
        arr[i] = input[i] - '0';
    }

    qsort(arr, read, sizeof(int), compare);

    for (int i = 0; i < read; i++) {
        printf("%d", arr[i]);
    }
    
    free(arr);
    return 0;
}