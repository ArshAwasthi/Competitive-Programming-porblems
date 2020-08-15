//Maximum Square Matrix With All Zeros
//
//Given a n*m matrix which contains only 0s and 1s, find out the size of maximum square sub-matrix with all 0s. You need to return the size of square with all 0s.
//Input format :
//Line 1 : n and m (space separated positive integers)
//Next n lines : m elements of each row (separated by space).
//Output Format:
//Line 1 : Size of maximum square sub-matrix
//Sample Input :
//3 3
//1 1 0
//1 1 1
//1 1 1
//Sample Output :
//1



import java.util.*;
import java.math.*;
public class Solution {
	
	public static int findMaxSquareWithAllZeros(int[][] input){
		
        
        int[][] dp=new int[input.length][input[0].length];
        int lr=input.length-1;
        int lc=input[0].length-1;
        for(int i=dp.length-1;i>=0;i--){
            dp[i][lc]=input[i][lc] ^ 1;
        }
        for(int i=dp[0].length-1;i>=0;i--){
            dp[lr][i]=input[lr][i] ^ 1;
        }
        int size=0;

        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[i].length-2;j>=0;j--){
                if(input[i][j]==0){
            	if(dp[i+1][j+1]>0){
                    dp[i][j]=1+Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i][j+1]));
                    if(size<dp[i][j])
                        size=dp[i][j];
                }
                    else
                        dp[i][j]=1;
                }
            }
        }
        if(size>0)
        return size;
        else
            return 1;
	}

	
}