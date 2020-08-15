//Largest Bitonic Subarray
//
//Send Feedback
//You are given an array of positive integers as input. Write a code to return the length of the largest such subsequence in which the values are arranged first in strictly ascending order and then in strictly descending order.
//Such a subsequence is known as bitonic subsequence. A purely increasing or purely decreasing subsequence will also be considered as a bitonic sequence with the other part empty.
//Note that the elements in bitonic subsequence need not be consecutive in the given array but the order should remain same.
//Input Format:
//Line 1 : A positive Integer N, i.e., the size of array
//Line 2 : N space-separated integers as elements of the array 
//Output Format:
//Length of Largest Bitonic subsequence
//Input Constraints:
//1<= N <= 100000
//Sample Input 1:
//6
//15 20 20 6 4 2
//Sample Output 1:
//5
//Sample Output 1 Explanation:
//Here, longest Bitonic subsequence is {15, 20, 6, 4, 2} which has length = 5.
//Sample Input 2:
//2
//1 5
//Sample Output 2:
//2
//Sample Input 3:
//2
//5 1
//Sample Output 3:
//2



public class Solution {
	
	
	
	public static int longestBitonicSubarray(int[] arr){
	int[] arr1,arr2;
        arr1=new int[arr.length];
        arr2=new int[arr.length];
        arr1[0]=arr2[arr.length-1]=1;
        int output=0;
        for(int i=1;i<arr.length;i++){
            arr1[i]=1;
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[i])
                    continue;
            	if(arr[j]<arr[i]&&arr1[j]>=arr1[i])
                    arr1[i]=arr1[j]+1;
                
            }
        }
        for(int i=arr.length-1;i>=0;i--){
            arr2[i]=1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i])
                    continue;
                if(arr[j]<arr[i]&&arr2[j]>=arr2[i])
                    arr2[i]=arr2[j]+1;
            }
            if((arr1[i]+arr2[i]-1)>output)
                output=arr1[i]+arr2[i]-1;
        }
     }
		
		return output;
	}

}

