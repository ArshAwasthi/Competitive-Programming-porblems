//Number Of Balanced BTs
//
//Given an integer h, find the possible number of balanced binary trees of height h. You just need to return the count of possible binary trees which are balanced.
//This number can be huge, so return output modulus 10^9 + 7.
//Write a simple recursive solution.
//Input Format :
//Integer h
//Output Format :
//Count % 10^9 + 7
//Input Constraints :
//1 <= h <= 40
//Sample Input 1:
//3
//Sample Output 1:
//15
//Sample Input 2:
//4
//Sample Output 2:
//315


import java.util.*;
import java.math.*;
public class Solution {
public static int mod=(int)Math.pow(10,9)+7;
    public static int solve(int height,long[] arr){
        if(height==1||height==0)
            return 1;
        if(arr[height]>0)
            return (int)arr[height];
        int x=solve(height-1,arr);
        int y=solve(height-2,arr);
        int xm=((x%mod)+mod)%mod;
        int ym=((y%mod)+mod)%mod;
     int a=(int)(((long)(x)*x)%mod);
        long b=((2*(((xm*ym)+mod)%mod))+mod)%mod;
        arr[height]=(((a%mod+b%mod)+mod)%mod);
		return (int)arr[height];
    }
	public static int balancedTreesOfHeightH(int height){
		long[] arr=new long[height+1];
        Arrays.fill(arr,0,arr.length,0);
        return solve(height,arr);
	}
}