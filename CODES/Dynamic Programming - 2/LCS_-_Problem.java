//LCS - Problem
//
//Given 2 strings of S1 and S2 with lengths m and n respectively, find the length of longest common subsequence.
//A subsequence of a string S whose length is n, is a string containing characters in same relative order as they are present in S, but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to n. E.g. subsequences of string "abc" are - "",a,b,c,ab,bc,ac,abc.
//Input Format :
//Line 1 : String S1
//Line 2 : String s2
//Output Format :
//Line 1 : Length of lcs
//Sample Input :
//adebc
//dcadb
//Sample Output :
//3

import java.math.*;
import java.util.*;
public class Solution {

	public static int lcs2(String s1, String s2,int[][] dp){
           
		if(s1.length()<=0||s2.length()<=0||s1.equals("")||s2.equals(""))
			return 0;
        if(dp[s1.length()][s2.length()]>=0)
            return dp[s1.length()][s2.length()];
        int out=0;
		if(s1.charAt(0)==s2.charAt(0))
			out=1+lcs2(s1.substring(1,s1.length()),s2.substring(1,s2.length()),dp);
        else
			out= Math.max(lcs2(s1.substring(1,s1.length()),s2,dp) , lcs2(s1,s2.substring(1,s2.length()),dp));
        dp[s1.length()][s2.length()]=out;
        return out;
	}
	public static int lcs(String s1, String s2){
       int size=Math.max(s1.length(),s2.length());
       int[][] arr=new int[size+1][size+1];
        for(int i=0;i<size+1;i++)
            Arrays.fill(arr[i],-1);
        return lcs2(s1,s2,arr);
		
	}
}
