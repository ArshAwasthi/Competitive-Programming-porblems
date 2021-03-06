//Dilemma
//
//Abhishek, a blind man recently bought N binary strings all of equal length .A binary string only contains '0's and '1's . The strings are numbered from 1 to N and all are distinct, but Abhishek can only differentiate between these strings by touching them. In one touch Abhishek can identify one character at a position of a string from the set. Find the minimum number of touches T Abhishek has to make so that he learn that all strings are different .
//Constraints :
//2<=N<=10
//1<=|L|<=100 , L is length of the strings .
//Input Format:
//Line 1 : An Integer N, denoting the number of binary strings .
//Next N lines : strings of equal length
//Output Format:
//Return the minimum number of touches
//Sample Input :
//2
//111010
//100100
//Sample Output :
//2


import java.math.*;
import java.util.*;
public class solution {
   
    public static int solve(int pos,String[] input,int mask,int[][] dp){
        
         if((mask&(mask-1))==0)
             return 0;
        
         if(pos<0)
            return 10000;
        
       if(dp[mask][pos]!=Integer.MAX_VALUE)
            return dp[mask][pos];
        
        int mask1=0;
        int mask2=0;
        int touches=0;
        for(int i=0;i<input.length;i++){
            if((mask&(1<<i))!=0){
                
                touches++;
                if(input[i].charAt(pos)=='0')
                {
                mask1=mask1|(1<<i);
            }
            else{
                mask2=mask2|(1<<i);
                
            }
        }
        }
     int ans1=touches+solve(pos-1,input,mask1,dp)+solve(pos-1,input,mask2,dp);
        int ans2=solve(pos-1,input,mask,dp);
        int sum=Math.min(ans1,ans2);
  
    	dp[mask][pos]=sum;
        return sum;
    }
	public static int minimumTouchRequired(int n, String[] input) {
       int[][] dp=new int[(1<<n)+1][input[0].length()+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],0,dp[i].length,Integer.MAX_VALUE);
        return solve(input[0].length()-1,input,(1<<(n))-1,dp);
		
	}
}