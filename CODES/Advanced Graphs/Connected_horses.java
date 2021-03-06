//Connected horses
//
//You all must be familiar with the chess-board having 
//8*8 squares of alternate black and white cells. Well, here 
//we have for you a similar 
//N*M size board with similar arrangement of black and white 
//cells.
//A few of these cells have Horses placed over them. 
//Each horse is unique. Now these horses are not the 
//usual horses which could jump to any of the 
//8 positions they usually jump in. They can move only if there is another horse on one of the 8-positions that it can     go to usually and then both the horses will swap their positions. This swapping can happen infinitely times.
//A photographer was assigned to take a picture of all the different ways that the horses occupy the board! Given the state of the board, calculate answer. Sincethis answer may be quite large, calculate in modulo 
//10^9+7
//Input:
//First line contains 
//T which is the number of test cases.
//T test cases follow first line of each containing three integers 
//N, M and Q where 
//N,M is the size of the board and 
//Q is the number of horses on it.
//
//Q lines follow each containing the 2 integers 
//X and Y which are the coordinates of the Horses.
//Output:
//For each test case, output the number of photographs taken by photographer.
//Constraints:
// 1<=T<=10
// 1<=N,M<=1000
// 1<=Q<=N*M
//SAMPLE INPUT
//2
//4 4 4
//1 1
//1 2
//3 1
//3 2
//4 4 4
//1 1
//1 2
//3 1
//4 4
//SAMPLE OUTPUT
//4
//2

#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#define N 1000000007
 
bool matrix[1001][1001], visited[1001][1001];
long long fact[1000000], count;
 
void factorial()
{
    fact[0] = fact[1] = 1;
 
    for (int i = 2; i < 1000000; i++)
        fact[i] = (i * (fact[i - 1]) % N + N ) % N;
}
 
bool dfs(int x, int y, int row, int column)
{
    if (x < 0 || y < 0 || x >= row || y >= column)
        return 0;
 
    if (visited [x][y])
        return 0;
 
    if (!matrix [x][y])
        return 0;
 
    visited [x][y] = true;
 
    count = (count + dfs (x + 2, y - 1, row, column)) % N;
    count = (count + dfs (x + 2, y + 1, row, column)) % N;
    count = (count + dfs (x + 1, y - 2, row, column)) % N;
    count = (count + dfs (x - 1, y - 2, row, column)) % N;
    count = (count + dfs (x - 2, y - 1, row, column)) % N;
    count = (count + dfs (x - 2, y + 1, row, column)) % N;
    count = (count + dfs (x - 1, y + 2, row, column)) % N;
    count = (count + dfs (x + 1, y + 2, row, column)) % N;
    
    return 1;
}
 
int main ()
{
    //freopen ("a.txt", "r", stdin);
    int t, row, column, query, i, j;
    long long ans;
    factorial();
    scanf ("%d", &t);
 
    while (t --) {
 
        ans = 1;
        memset (matrix, 0, sizeof(matrix));
        memset (visited, false, sizeof(visited));
        scanf ("%d %d %d", &row, &column, &query);
 
        while (query--) {
 
            scanf ("%d %d", &i, &j);
            matrix[i - 1][j - 1] = 1;
        }
 
        for (i = 0; i < row; i++) {
 
            for (j = 0; j < column; j++) {
 
                if (matrix[i][j] && !(visited[i][j]))
                    dfs (i, j, row, column);
 
                ans = (ans * (fact[count + 1]) % N + N) % N;
                count = 0;
            }
        }
 
        printf("%lli\n", ans);
    }
    
    return 0;
}