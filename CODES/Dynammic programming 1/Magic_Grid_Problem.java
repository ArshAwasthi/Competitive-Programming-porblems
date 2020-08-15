//Magic Grid Problem
//
//You are given a magrid S ( a magic grid ) having R rows and C columns. Each cell in this magrid has either a Hungarian horntail dragon that our intrepid hero has to defeat, or a flask of magic potion that his teacher Snape has left for him. A dragon at a cell (i,j) takes away |S[i][j]| strength points from him, and a potion at a cell (i,j) increases Harry's strength by S[i][j]. If his strength drops to 0 or less at any point during his journey, Harry dies, and no magical stone can revive him.
//Harry starts from the top-left corner cell (1,1) and the Sorcerer's Stone is in the bottom-right corner cell (R,C). From a cell (i,j), Harry can only move either one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) and he can not move outside the magrid. Harry has used magic before starting his journey to determine which cell contains what, but lacks the basic simple mathematical skill to determine what minimum strength he needs to start with to collect the Sorcerer's Stone. Please help him once again.
//Input (STDIN)
//The first line contains the number of test cases T. T cases follow. Each test case consists of R C in the first line followed by the description of the grid in R lines, each containing C integers. Rows are numbered 1 to R from top to bottom and columns are numbered 1 to C from left to right. Cells with S[i][j] < 0 contain dragons, others contain magic potions.
//Output (STDOUT):
//Output T lines, one for each case containing the minimum strength Harry should start with from the cell (1,1) to have a positive strength through out his journey to the cell (R,C).
//Constraints:
//1 = T = 5
//
//2 = R, C = 500
//
//-10^3 = S[i][j] = 10^3
//
//S[1][1] = S[R][C] = 0
//Sample Input
//3
//2 3
//0 1 -3
//1 -2 0
//2 2
//0 1
//2 0
//3 4
//0 -2 -3 1
//-1 4 0 -2
//1 -2 -3 0
//Sample Output
//2
//1
//2


import java.util.*;
import java.math.*;
public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int cases=in.nextInt();
        for(int l=0;l<cases;l++){
            //for each input grid
            int row=in.nextInt();
            int col=in.nextInt();
            int[][] grid=new int[row][col];
            int[][] dp=new int[row][col];
            //initilising grid
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<col;j++)
                    grid[i][j]=in.nextInt();
            }
            dp[dp.length-1][col-1]=dp[dp.length-2][col-1]=dp[dp.length-1][col-2]=1;
            //finding minimum cost for rows
            for(int i=dp.length-3;i>=0;i--){
                if(grid[i+1][col-1]<=0)
                dp[i][col-1]=Math.abs(grid[i+1][col-1])+dp[i+1][col-1];
				else
                	if(grid[i+1][col-1]>0&&grid[i+1][col-1]<dp[i+1][col-1])
                	dp[i][col-1]=dp[i+1][col-1]-grid[i+1][col-1];
                	else
                        dp[i][col-1]=1;
            }
            for(int i=col-3;i>=0;i--){
                if(grid[dp.length-1][i+1]<=0)
                dp[dp.length-1][i]=Math.abs(grid[dp.length-1][i+1])+dp[dp.length-1][i+1];
				else
                	if(grid[dp.length-1][i+1]>0&&dp[dp.length-1][i+1]>grid[dp.length-1][i+1])
                	dp[dp.length-1][i]=dp[dp.length-1][i+1]-grid[dp.length-1][i+1];
                	else
                        dp[dp.length-1][i]=1;
            }
          
            //filling whole DP matrix
            for(int i=dp.length-2;i>=0;i--){
                for(int j=col-2;j>=0;j--){
                    //fill values
                    int low=0;
                    int right=0;
                    if(grid[i+1][j]<0){
                        low=Math.abs(grid[i+1][j])+dp[i+1][j];
                    }
                    else{
                        if(dp[i+1][j]>grid[i+1][j])
                        	low=dp[i+1][j]-grid[i+1][j];
                        else
                            low=1;
                    }
                    if(grid[i][j+1]<0){
                        right=Math.abs(grid[i][j+1])+dp[i][j+1];
                    }
                    else{
                        if(dp[i][j+1]>grid[i][j+1])
                            right=dp[i][j+1]-grid[i][j+1];
                        else
                            right=1;
                    }
                    dp[i][j]=Math.min(low,right);
            }
            }
            System.out.println(dp[0][0]);
        }
	}

}