//Trader Profit
//
//Mike is a stock trader and makes a profit by buying and selling stocks. He buys a stock at a lower price and sells it at a higher price to book a profit. He has come to know the stock prices of a particular stock for n upcoming days in future and wants to calculate the maximum profit by doing the right transactions (single transaction = buying + selling). Can you help him maximize his profit?
//Note: A transaction starts after the previous transaction has ended. Two transactions can't overlap or run in parallel.
//The stock prices are given in the form of an array A for n days.
//Given the stock prices and a positive integer k, find and print the maximum profit Mike can make in at most k transactions.
//Input Format
//The first line of input contains an integer q denoting the number of queries.
//
//The first line of each test case contains a positive integer k, denoting the number of transactions. 
//
//The second line of each test case contains a positive integer n, denoting the length of the array A.
//
//The third line of each test case contains n space-separated positive integers, denoting the prices of each day in the array A.
//Constraints
//1<=q<=100
//
//0<k<10
//
//2<=n<=30
//
//0<=elements of array A<=1000
//Output Format
//For each query print the maximum profit earned by Mike on a new line. 
//Sample Input
//3
//2
//6
//10 22 5 75 65 80
//3
//4
//20 580 420 900
//1
//5
//100 90 80 50 25
//Sample Output
//87
//1040
//0

import java.util.*;
import java.math.*;
public class Main {

	public static int solve(int[] arr,int k,int n,int ongoing,int[][][] dp){
        if(arr.length<=0)
            return 0;
        int a=0;
        if(dp[ongoing][n][k]>-1)
            return dp[ongoing][n][k];
        int val=solve(Arrays.copyOfRange(arr,1,arr.length),k,n-1,ongoing,dp);
        if(ongoing==1){
            a=arr[0]+solve(Arrays.copyOfRange(arr,1,arr.length),k-1,n-1,0,dp);
            dp[ongoing][n][k]=Math.max(val,a);
            return Math.max(val,a);
        }
        else{
            if(k<=0)
                return 0;
        	int x=solve(Arrays.copyOfRange(arr,1,arr.length),k,n-1,1,dp)-arr[0];
            dp[ongoing][n][k]=Math.max(x,val);
        return Math.max(x,val);
        }
    }
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int cases=in.nextInt();
        for(int l=0;l<cases;l++){
        int k=in.nextInt();
        int n=in.nextInt();
        int[] arr=new int[n];
            for(int i=0;i<arr.length;i++){
                arr[i]=in.nextInt();
            }
            
        int[][][] dp=new int[2][n+1][k+1];
           for(int i=0;i<dp.length;i++){
               for(int j=0;j<dp[i].length;j++)
                   Arrays.fill(dp[i][j],0,dp[i][j].length,-1);
           }
           
            System.out.println(solve(arr,k,n-1,0,dp));
        }
	}

}