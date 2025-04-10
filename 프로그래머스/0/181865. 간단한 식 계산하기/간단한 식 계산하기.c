#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(const char* binomial) {
    int num1, num2;
    char op;
    
    sscanf(binomial, "%d %c %d", &num1, &op, &num2);
    
    int answer;
    
    switch (op) {
        case '+':
            answer = num1 + num2;
            break;
        case '-':
            answer = num1 - num2;
            break;
        case '*':
            answer = num1 * num2;
            break;
        default:
            break;
    }
    
    return answer;
}