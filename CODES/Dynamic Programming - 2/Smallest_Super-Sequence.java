//Smallest Super-Sequence
//
//Given two strings S and T, find and return the length of their smallest super-sequence.
//A shortest super sequence of two strings is defined as the shortest possible string containing both strings as subsequences.
//Note that if the two strings do not have any common characters, then return the sum of lengths of the two strings.
//Input Format:
//Line 1 : A string
//Line 2: Another string
//Output Format:
//Length of the smallest super-sequence of given two strings. 
//Sample Input:
//ab
//ac
//Sample Output:
//3
//Sample Output Explanation:
//Their smallest super-sequence can be "abc" which has length=3.


import java.util.*;
import java.math.*;
 class Solution {
static int mod=(int)Math.pow(10,9)+7;
	public static int solve(char[] arr,int n){
        if(arr.length<=0||n<=0)
            return 0;
        int x=0;
        int y=0;
        int v=1;
        
            x=solve(Arrays.copyOfRange(arr,1,arr.length),n-1)+1;
         y=solve(Arrays.copyOfRange(arr,1,arr.length),n-1);
        return ((x%mod)+(y%mod))%mod;
    }
     
    public static int smallestSuperSequence(String str1,String str2){
          int[][] arr=new int[str1.length()+1][str2.length()+1];
        for(int i=arr.length-2;i>=0;i--){
            arr[i][arr[0].length-1]=arr[i+1][arr[0].length-1]+1;
        }
        for(int i=arr[0].length-2;i>=0;i--){
            arr[arr.length-1][i]=arr[arr.length-1][i+1]+1;
        }
        
        for(int i=arr.length-2;i>=0;i--){
            for(int j=arr[0].length-2;j>=0;j--){
               if(str1.charAt(i)==str2.charAt(j))
                   arr[i][j]=1+arr[i+1][j+1];
                else{
                    arr[i][j]=1+Math.min(arr[i+1][j],arr[i][j+1]);
                }
            }
        }
 
        return arr[0][0];
     }
   
}