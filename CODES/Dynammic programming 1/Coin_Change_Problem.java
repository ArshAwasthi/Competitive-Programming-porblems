//Coin Change Problem
//
//You are given an infinite supply of coins of each of denominations D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make change for Value V using coins of denominations D.
//Note : Return 0, if change isn't possible.
//Input Format
//Line 1 : Integer n i.e. total number of denominations
//Line 2 : N integers i.e. n denomination values
//Line 3 : Value V
//Output Format
//Line 1 :  Number of ways i.e. W
//Constraints :
//1<=n<=10
//1<=V<=1000
//Sample Input 1 :
//3
//1 2 3
//4
//Sample Output
//4
//Sample Output Explanation :
//Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).

import java.util.*;
public class Solution {

	public static int solve(int denominations[], int value,int[][] store){
        if(value==0)
        return 1;
    if(value<0)
        return 0;
        if(denominations.length==0)
            return 0;
        if(store[denominations.length-1][value-1]>-1)
            return store[denominations.length-1][value-1];
	int out=solve(denominations, value-denominations[0],store);
	out+=solve(Arrays.copyOfRange(denominations,1,denominations.length), value,store);
    store[denominations.length-1][value-1]=out;
    return out;
    }
	public static int countWaysToMakeChange(int denominations[], int value){
	int[][] arr=new int[denominations.length][value];
       
    for(int i=0;i<denominations.length;i++)
        Arrays.fill(arr[i],0,value,-1);
    return solve(denominations,value,arr);
    }
	
}
