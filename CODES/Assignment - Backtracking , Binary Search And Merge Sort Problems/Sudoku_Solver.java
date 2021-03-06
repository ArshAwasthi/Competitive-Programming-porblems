//Sudoku Solver
//
//Given a 9*9 sudoku board, in which some entries are filled and others are 0 (0 indicates that the cell is empty), you need to find out whether the Sudoku puzzle can be solved or not i.e. return true or false.
//Input Format :
//9 Lines where ith line contains ith row elements separated by space
//Output Format :
// true or false
//Sample Input :
//9 0 0 0 2 0 7 5 0 
//6 0 0 0 5 0 0 4 0 
//0 2 0 4 0 0 0 1 0 
//2 0 8 0 0 0 0 0 0 
//0 7 0 5 0 9 0 6 0 
//0 0 0 0 0 0 4 0 1 
//0 1 0 0 0 5 0 8 0 
//0 9 0 0 7 0 0 0 4 
//0 8 2 0 4 0 0 0 6
//Sample Output :
//true

import java.util.*;
public class Solution {
	public static boolean isSolved(int board[][],int r,int c){
       HashSet<Integer> set=new HashSet<>();
        for(int i=r;i<(r+3);i++){
            for(int j=c;j<(c+3);j++){
                //row check
                HashSet<Integer> rowset=new HashSet<>();
                     HashSet<Integer> colset=new HashSet<>();
                for(int k=0;k<9;k++){
                     
        				if((board[j][k]>0&&!rowset.add(board[j][k]))||(board[i][k]>0&&!colset.add(board[i][k])))
                            return false;
                }
                if(rowset.size()>=9&&colset.size()>=9)
                    return false;
                if(board[i][j]>0&&!set.add(board[i][j]))
                    return false;
            }
        }
        if(set.size()>=9)
            return false;
        return true;
    }
	
	
	public static boolean sudokuSolver(int board[][]){
		boolean solve=true;
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                if(!isSolved(board,i,j)){
                    return false;
                }
            }
            if(!solve)
                break;
        }
	return true;
		
	}

	
	
}
