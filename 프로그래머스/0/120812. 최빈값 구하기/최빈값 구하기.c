#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define N 1000

int max(int a, int b) {
    return (a > b) ? a : b;
}

int solution(int array[], size_t array_len) {
    int answer = 0;
    int arr[N] = {0};
    
    for (int i = 0; i < array_len; i++) {
        arr[array[i]]++;
    }
    
    int maxCounts = 0;
    bool check = false;
    for (int i = 0; i < N; i++) {
        maxCounts = max(maxCounts, arr[i]);
    }
    
    for (int i = 0; i < array_len; i++) {
        if (maxCounts == arr[array[i]] && !check) {
            answer = array[i];
            check = true;
            continue;
        }
        if (maxCounts == arr[array[i]] && check && array[i] != answer) {
            return -1;
        }
    }
    
    return answer;
}