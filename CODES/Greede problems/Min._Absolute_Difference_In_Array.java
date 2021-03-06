//Min. Absolute Difference In Array
//
//Given an integer array A of size N, find and return the minimum absolute difference between any two elements in the array.
//We define the absolute difference between two elements ai, and aj (where i != j ) is |ai - aj|.
//Input format :
//Line 1 : Integer N, Array Size
//Line 2 : Array elements (separated by space)
//Output Format :
//Minimum difference
//Constraints :
//1 <= N <= 10^6
//Sample Input :
//5
//2 9 0 4 5
//Sample Input :
//1

import java.util.*;
import java.math.*;
public class Solution {

	public static int minAbsoluteDifference(int input[]) {
		Arrays.sort(input);
    	int diff=Integer.MAX_VALUE;
        for(int i=0;i<input.length-1;i++){
            int temp=Math.abs(input[i]-input[i+1]);
            if(temp<diff)
                diff=temp;
        }
        return diff;

	}

}
