//Rat In A Maze Problem
//
//You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
//Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.
//Input Format
//Line 1 : Integer N
//Next N Lines : Each line will contain ith row elements (separated by space)
//Output Format :
//One Line for every possible solution. 
//Every line will have N*N maze elements printed row wise and are separated by space. Only cells that are part of solution path should be 1, rest all cells should be 0.
//Sample Input 1 :
//3
//1 0 1
//1 0 1
//1 1 1
//Sample Output 1 :
//1 0 0 1 0 0 1 1 1 
//Sample Output 1 Explanation :
//Only 1 path is possible
//Sample Input 2 :
//3
//1 0 1
//1 1 1
//1 1 1
//Sample Output 2 :
//1 0 0 1 1 1 1 1 1 
//1 0 0 1 0 0 1 1 1 
//1 0 0 1 1 0 0 1 1 
//1 0 0 1 1 1 0 0 1 
//Sample Output 2 Explanation :
//4 paths are possible


import java.util.*;
public class Solution {
	
	
	public static void solve(int problem[][],int sol[][],int r,int c){
       
        if(sol[r][c]==1||problem[r][c]==0){
            return ;
        }
        if(r>=problem.length||c>=problem.length)
            return ;
        if(r==problem.length-1&&c==problem.length-1){
            sol[r][c]=1;
            for(int i=0;i<sol.length;i++){
                for(int j=0;j<sol.length;j++){
                    System.out.print(sol[i][j]+" ");
                }
        }
            sol[r][c]=0;
        System.out.println();
            return ;
        }
        sol[r][c]=1;
        if(r-1>=0)
            solve(problem,sol,r-1,c);
        if(c-1>=0)
            solve(problem,sol,r,c-1);
        if(r+1<sol.length)
            solve(problem,sol,r+1,c);
        if(c+1<sol.length)
            solve(problem,sol,r,c+1);
         sol[r][c]=0;
        
    }
	public static void ratInAMaze(int maze[][]){
		
	int[][] sol=new int[maze.length][maze.length];
        for(int i=0;i<maze.length;i++)
            Arrays.fill(sol[i],0,maze.length,0);
        solve(maze,sol,0,0);
	}
	
	
	
}
