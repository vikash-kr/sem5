import queue
import copy

global N =8

def printSolution(board) :
    for i in range(N) :
        for j in range(N) :
            print(board[i][j],end=" ")
        print("\n")
    print("=============")

def isSafe(board, row, col) :
    for i in range(col) :
        if board[row][i] == 1 :
            return False
    
    for i,j in zip(range(row,-1,-1), range(col,-1,-1)) :
        if board[i][j] == 1 :
            return False
    
    for i,j in zip(range(row,N,1), range(col,-1,-1)) :
        if board[i][j] == 1 :
            return False
    
    return True

def solveNQ() :
    board = [[0 for j in range(N)] for i in range(N)]
    q = queue.Queue()
    q.put([board,0])
    c = 0 #count of move
    while not q.empty() :
        p = q.get()
        col = p[1]
        tmp = copy.deepcopy(p[0]) 
        if col >= N :
            return c
        for i in range(N) :
            if isSafe(tmp,i,col) :
                tm = copy.deepcopy(tmp)
                tm[i][col] = 1 
                if col == N-1:
                    c = c + 1
                    printSolution(tm)
                q.put([tm,col+1])
    
c = solveNQ()
print("Total solutions = ",c)
#printSolution(board)
