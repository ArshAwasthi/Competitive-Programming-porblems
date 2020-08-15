//Loot Houses
//
//A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
//Input Format
//Line 1 : An integer N 
//Line 2 : N spaced integers denoting money in each house
//Output Format
// Line 1 : Maximum amount of money looted
//Input Constraints
//1 <= n <= 10^4
//1 <= A[i] < 10^4
//Sample Input :
//6
//5 5 10 100 10 5
//Sample Output 1 :
//110

import java.util.*;
import java.math.*;
public class Solution {
	
    public static int getMaxMoney(int arr[], int n){
    if(arr.length==1)
        return arr[0];
    if(arr.length==2)
        return Math.max(arr[0],arr[1]);
    	int[] dp=new int[n];
        dp[0]=arr[0];
        dp[1]=arr[1];
        dp[2]=arr[2]+arr[0];
        for(int i=3;i<arr.length;i++){
            dp[i]=arr[i]+Math.max(dp[i-2],dp[i-3]);
        }
    return Math.max(dp[dp.length-1],dp[dp.length-2]);
    }
   
}
