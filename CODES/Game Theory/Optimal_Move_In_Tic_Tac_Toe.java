//Optimal Move In Tic Tac Toe
//
//Given a state of 3*3 Tic Tac Toe Board and two players 'x' and 'o', find the best optimal move possible for player 'x' specifying row and column. Also calculate the score by using the corresponding evaluation function.
//Assume that there are 2 possible ways for 'x' to win the game from a give board state.
//Move A : 'x' can win in 2 move
//Move B : 'x' can win in 4 moves
//The evaluation function may return a value of +10 for both moves A and B. Even though the move A is better because it ensures a faster victory, but we may choose B sometimes. To overcome this problem we subtract the depth value from the evaluated score. This means that in case of a victory it will choose the victory which takes least number of moves and in case of a loss it will try to prolong the game and play as many moves as possible. So the new evaluated value will be
//Move A will have a value of +10 – 2 = 8
//Move B will have a value of +10 – 4 = 6
//Now since move A has a higher score compared to move B our AI will choose move A over move B. The same thing must be applied to the minimizer. Instead of subtracting the depth we add the depth value as the minimizer always tries to get, as negative a value as possible. Pseudocode implementation is as follows.
//if maximizer has won:
//    return WIN_SCORE – depth
//
//else if minimizer has won:
//    return LOOSE_SCORE + depth 
//Input Format
// Integer 'n'(Number of given states of board)
// For each state we will have three values
// row number , column number , player name('x' or 'o')
//Output Format
// (Evaluated Score) row: (Row Number) col: (Column Number)
//Sample Input 1
//5
//0 0 x
//0 1 o
//0 2 x
//1 0 o
//1 2 x
//Sample Output 1
//10 row: 1 col: 1

#include<bits/stdc++.h> 
using namespace std; 
  
struct Move 
{ 
    int row, col; 
}; 
  
char player = 'x', opponent = 'o'; 
  
// This function returns true if there are moves 
// remaining on the board. It returns false if 
// there are no moves left to play. 
bool isMovesLeft(char board[3][3]) 
{ 
    for (int i = 0; i<3; i++) 
        for (int j = 0; j<3; j++) 
            if (board[i][j]=='_') 
                return true; 
    return false; 
} 
  
// This is the evaluation function as discussed 
// in the previous article ( http://goo.gl/sJgv68 ) 
int evaluate(char b[3][3]) 
{ 
    // Checking for Rows for X or O victory. 
    for (int row = 0; row<3; row++) 
    { 
        if (b[row][0]==b[row][1] && 
            b[row][1]==b[row][2]) 
        { 
            if (b[row][0]==player) 
                return +10; 
            else if (b[row][0]==opponent) 
                return -10; 
        } 
    } 
  
    // Checking for Columns for X or O victory. 
    for (int col = 0; col<3; col++) 
    { 
        if (b[0][col]==b[1][col] && 
            b[1][col]==b[2][col]) 
        { 
            if (b[0][col]==player) 
                return +10; 
  
            else if (b[0][col]==opponent) 
                return -10; 
        } 
    } 
  
    // Checking for Diagonals for X or O victory. 
    if (b[0][0]==b[1][1] && b[1][1]==b[2][2]) 
    { 
        if (b[0][0]==player) 
            return +10; 
        else if (b[0][0]==opponent) 
            return -10; 
    } 
  
    if (b[0][2]==b[1][1] && b[1][1]==b[2][0]) 
    { 
        if (b[0][2]==player) 
            return +10; 
        else if (b[0][2]==opponent) 
            return -10; 
    } 
  
    // Else if none of them have won then return 0 
    return 0; 
} 
  
// This is the minimax function. It considers all 
// the possible ways the game can go and returns 
// the value of the board 
int minimax(char board[3][3], int depth, bool isMax) 
{ 
    int score = evaluate(board); 
  
    // If Maximizer has won the game return his/her 
    // evaluated score 
    if (score == 10) 
        return score; 
  
    // If Minimizer has won the game return his/her 
    // evaluated score 
    if (score == -10) 
        return score; 
  
    // If there are no more moves and no winner then 
    // it is a tie 
    if (isMovesLeft(board)==false) 
        return 0; 
  
    // If this maximizer's move 
    if (isMax) 
    { 
        int best = -1000; 
  
        // Traverse all cells 
        for (int i = 0; i<3; i++) 
        { 
            for (int j = 0; j<3; j++) 
            { 
                // Check if cell is empty 
                if (board[i][j]=='_') 
                { 
                    // Make the move 
                    board[i][j] = player; 
  
                    // Call minimax recursively and choose 
                    // the maximum value 
                    best = max( best, 
                        minimax(board, depth+1, !isMax) ); 
  
                    // Undo the move 
                    board[i][j] = '_'; 
                } 
            } 
        } 
        return best; 
    } 
  
    // If this minimizer's move 
    else
    { 
        int best = 1000; 
  
        // Traverse all cells 
        for (int i = 0; i<3; i++) 
        { 
            for (int j = 0; j<3; j++) 
            { 
                // Check if cell is empty 
                if (board[i][j]=='_') 
                { 
                    // Make the move 
                    board[i][j] = opponent; 
  
                    // Call minimax recursively and choose 
                    // the minimum value 
                    best = min(best, 
                           minimax(board, depth+1, !isMax)); 
  
                    // Undo the move 
                    board[i][j] = '_'; 
                } 
            } 
        } 
        return best; 
    } 
} 
  
// This will return the best possible move for the player 
Move findBestMove(char board[3][3]) 
{ 
    int bestVal = -1000; 
    Move bestMove; 
    bestMove.row = -1; 
    bestMove.col = -1; 
  
    // Traverse all cells, evaluate minimax function for 
    // all empty cells. And return the cell with optimal 
    // value. 
    for (int i = 0; i<3; i++) 
    { 
        for (int j = 0; j<3; j++) 
        { 
            // Check if cell is empty 
            if (board[i][j]=='_') 
            { 
                // Make the move 
                board[i][j] = player; 
  
                // compute evaluation function for this 
                // move. 
                int moveVal = minimax(board, 0, false); 
  
                // Undo the move 
                board[i][j] = '_'; 
  
                // If the value of the current move is 
                // more than the best value, then update 
                // best/ 
                if (moveVal > bestVal) 
                { 
                    bestMove.row = i; 
                    bestMove.col = j; 
                    bestVal = moveVal; 
                } 
            } 
        } 
    } 
  
    printf("%d ",bestVal); 
  
    return bestMove; 
} 
int main() {
    char board[3][3]={ 
        { '_', '_', '_' }, 
        { '_', '_', '_' }, 
        { '_', '_', '_' } 
    }; 
    int queries=0;
    cin>>queries;
    for(int i=0;i<queries;i++)
    {
        int y=0;
        int x=0;
        char c='_';
        cin>>x>>y>>c;
        board[x][y]=c;
    }
	Move bestMove = findBestMove(board); 
 
    printf("row: %d col: %d", bestMove.row, bestMove.col ); 
    return 0; 
	// Write your code here
}