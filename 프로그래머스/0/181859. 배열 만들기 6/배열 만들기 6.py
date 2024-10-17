def solution(arr):
    stack = []
    print(len(arr))
    i = 0
    while i < len(arr) :
        if len(stack) == 0:
            stack.append(arr[i])
        elif stack[-1] == arr[i]:
            stack.pop()
        else:
            stack.append(arr[i])
        i += 1
        
    return stack if len(stack) != 0 else [-1]