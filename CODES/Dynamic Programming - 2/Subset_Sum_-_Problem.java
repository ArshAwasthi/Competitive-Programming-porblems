//Subset Sum - Problem
//
//Given a set of n integers, find if a subset of sum k can be formed from the given set. Print Yes or No.
//Input Format
//First line contains a single integer n (1<=n<=1000)
//Second line contains n space separated integers (1<=a[i]<=1000)
//Last line contains a single positive integer k (1<=k<=1000)
//Output Format
//Output Yes if there exists a subset whose sum is k, else output No.
//Sample Input
//3
//1 2 3
//4
//Sample Output
//Yes

import java.util.*;

public class Main {

	public static boolean solve(int[] arr,int sum){
        boolean[][] dp=new boolean[arr.length+1][sum+1];
        for(int i=0;i<arr.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=arr[i-1])
                    dp[i][j]=dp[i][j]||dp[i-1][j-arr[i-1]];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int size=in.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        int sum=in.nextInt();
        //calculate
        if(solve(arr,sum))
        System.out.println("Yes");
        else 
            System.out.println("No");
	}

}