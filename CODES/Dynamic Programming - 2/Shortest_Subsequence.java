//Shortest Subsequence
//
//Gary has two string S and V. Now Gary wants to know the length shortest subsequence in S such that it is not a subsequence in V.
//Note: input data will be such so there will always be a solution.
//Input Format :
//Line 1 : String S of length N (1 <= N <= 1000)
//Line 2 : String V of length M (1 <= M <= 1000)
//Output Format :
//Length of shortest subsequence in S such that it is not a subsequence in V
//Sample Input :
//babab
//babba
//Sample Output :
//3

//NOT SATESFY ALL TESTCASES

import java.util.*;
public class solution {
    public int solve2(String S,String V,int[][] dp){
        if(S.length()<=0||V.length()<=0)
            return 0;
        if(dp[S.length()][V.length()]>-1)
            return dp[S.length()][V.length()];
        int a=solve2(S.substring(1,S.length()),V,dp);
        int loc=-1;
        int b=0;
        for(int i=0;i<V.length();i++)
        {
            if(V.charAt(i)==S.charAt(0))
            {loc=i;
            break;
            }
        }
        if(loc==-1){
			dp[S.length()][V.length()]=a;
            return a;
        
        }
        else
            b=1+solve2(S.substring(1,S.length()),V.substring(loc+1,V.length()),dp);
		dp[S.length()][V.length()]=Math.max(a,b);
        return dp[S.length()][V.length()];
    }
	public int solve(String S,String V){
		int[][] arr=new int[S.length()+1][V.length()+1];
        for(int i=0;i<arr.length;i++)
            Arrays.fill(arr[i],0,arr[0].length,-1);
        return solvex(S.toCharArray(),V.toCharArray(),S.length(),V.length(),arr);
	}
	static final int MAX = 1005; 
  
/* A recursive function to find the length of 
shortest uncommon subsequence*/
static int solvex(char []S, char []T, int m, int n,int[][] dp) 
{ 
    // S String is empty 
    if (m == 0) 
        return MAX; 
  
    // T String is empty 
    if (n <= 0) 
        return 1; 
    if(dp[m][n]>=0)
        return dp[m][n];
  
    // Loop to search for current character 
    int k; 
    for (k = 0; k < n; k++) 
        if (T[k] == S[0]) 
            break; 
  
    // char not found in T 
    if (k == n) 
        return 1; 
  
    // Return minimum of following two 
    // Not including current char in answer 
    // Including current char 
    dp[m][n]= Math.min(solvex(Arrays.copyOfRange(S, 1, S.length), T, m - 1, n,dp), 
                    1 + solvex(Arrays.copyOfRange(S, 1, S.length),  
                    Arrays.copyOfRange(T, k + 1, T.length), m - 1, n - k - 1,dp)); 
    return dp[m][n];
} 
  
}

