//All Indices of Number

//Given an array of length N and an integer x, you need to find all the indexes where x is present in the input array. Save all the indexes in an array (in increasing order).
//Do this recursively. Indexing in the array starts from 0.
//Input Format :
//Line 1 : An Integer N i.e. size of array
//Line 2 : N integers which are elements of the array, separated by spaces
//Line 3 : Integer x
//Output Format :
//indexes where x is present in the array (separated by space)
//Constraints :
//1 <= N <= 10^3
//Sample Input :
//5
//9 8 10 8 8
//8
//Sample Output :
//1 3 4

import java.util.*;


public class Solution {

	public static int[] allIndexes(int input[], int x) {
	    if(input.length==0)
            return new int[0]; 
        int[] arr=allIndexes(Arrays.copyOfRange(input,0,input.length-1),x);
		//System.out.println(input[input.length-1]);]
        
        if(input[input.length-1]==x)
        {
            if(arr.length==0)
            {
                int[] temparr=new int[1];
                temparr[0]=input.length-1;
            return temparr;
            }
            else
            {
                int[] temparr=Arrays.copyOfRange(arr,0,arr.length+1);
                temparr[temparr.length-1]=input.length-1;
                return temparr;
            }
           
        }
        return arr;
	}
	
}