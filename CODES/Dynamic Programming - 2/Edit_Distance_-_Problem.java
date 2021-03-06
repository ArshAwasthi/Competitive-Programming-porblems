//Edit Distance - Problem
//
//Given two strings s and t of lengths m and n respectively, find the Edit Distance between the strings. Edit Distance of two strings is minimum number of steps required to make one string equal to other. In order to do so you can perform following three operations only :
//1. Delete a character
//
//2. Replace a character with another one
//
//3. Insert a character
//Note - Strings don't contain spaces
//Input Format :
//Line 1 : String s
//Line 2 : String t
//Output Format :
//Line 1 : Edit Distance value
//Constraints
//1<= m,n <= 20
//Sample Input 1 :
//abc
//dc
//Sample Output 1 :
//2


import java.util.*;
import java.math.*;
public class Solution {
	public static int editDistance(String s1, String s2){
		int[][] arr=new int[s2.length()+1][s1.length()+1];
        int min=Math.min(s1.length(),s2.length())+1;
        int rem=Math.max(s1.length(),s2.length())+1;
    	boolean flag=(s1.length()>s2.length())?true:false;//true=s1
    
        for(int i=0;i<min;i++){
            arr[0][i]=i;
            if(i>0)
            arr[i][0]=i;
          
        }
        if(s1.length()!=s2.length())
        for(int i=min;i<rem;i++){
         
            if(flag)
                arr[0][i]=arr[0][i-1]+1;
            else
                arr[i][0]=arr[i-1][0]+1;
        }
        for(int i=1;i<arr.length;i++){
             for(int j=1;j<=s1.length();j++){
         		if(s1.charAt(j-1)==s2.charAt(i-1)){
                    arr[i][j]=arr[i-1][j-1];
                }
                 else{
                     arr[i][j]=1+Math.min(arr[i-1][j],Math.min(arr[i-1][j-1],arr[i][j-1]));
                 }
             }
        }
        
	return arr[arr.length-1][s1.length()];
	}

	
}
