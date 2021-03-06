//N-Queen Problem
//
//You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
//Input Format :
//Line 1 : Integer N
//Output Format :
//One Line for every board configuration. 
//Every line will have N*N board elements printed row wise and are separated by space
//Note : Don't print anything if there isn't any valid configuration.
//Constraints :
//1<=N<=10
//Sample Input 1:
//4
//Sample Output 1 :
//0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
//0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0 


import java.util.*;
public class Solution {

public static boolean isSafe(int[][] board,int row,int col){
    for(int i=0;i<board.length;i++){
         //checking rows and column
        if(board[row][i]==1)
            return false;
        if(board[i][col]==1)
            return false;
            //checking digonals
        if(row+i<board.length&&col-i>=0)
        if(board[row+i][col-i]==1)
            return false;
        if(row-i>=0&&col-i>=0)
        if(board[row-i][col-i]==1)
            return false;
        if(row-i>=0&&col+i<board.length)
        if(board[row-i][col+i]==1)
            return false;
        if(row+i<board.length&&col+i<board.length)
        if(board[row+i][col+i]==1)
            return false;
    }
    return true;
}
public static boolean NQ(int[][] board,int queens,int row){
    if(queens<=0){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
        }
        System.out.println();
    }
     if(row>=board.length)
        return false;
    for(int i=0;i<board.length;i++){
        boolean flag=false;
        if(isSafe(board,row,i)){
            board[row][i]=1;
            flag=NQ(board,queens-1,row+1);
        }
        if(!flag)
            board[row][i]=0;
        
    }
    return false;
}
public static void placeNQueens(int n){
		int[][] board=new int[n][n];
    for(int i=0;i<n;i++)
        Arrays.fill(board[i],0,board.length,0);
    NQ(board,n,0);
	

	}
	
}