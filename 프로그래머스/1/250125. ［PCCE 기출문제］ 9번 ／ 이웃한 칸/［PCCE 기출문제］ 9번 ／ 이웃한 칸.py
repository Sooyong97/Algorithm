def solution(board, h, w):
    answer = 0
    direction = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    
    n = len(board)
    m = len(board[0])
    
    for dx, dy in direction:
        nx = h + dx
        ny = w + dy
        
        if 0 <= nx < n and 0 <= ny < m:
            if board[h][w] == board[nx][ny]:
                answer += 1
                
    return answer