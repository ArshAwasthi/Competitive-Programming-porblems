//Merge Sort Code
//
//Sort an array A using Merge Sort.
//Change in the input array itself. So no need to return or print anything.
//Input format :
//Line 1 : Integer n i.e. Array size
//Line 2 : Array elements (separated by space)
//Output format :
//Array elements in increasing order (separated by space)
//Constraints :
//1 <= n <= 10^3
//Sample Input 1 :
//6 
//2 6 8 5 4 3
//Sample Output 1 :
//2 3 4 5 6 8
//Sample Input 2 :
//5
//2 1 5 2 3
//Sample Output 2 :
//1 2 2 3 5 

import java.util.*;
public class solution {
    public static void merge(int[] arr,int start,int mid,int end){
        int[] arr1=Arrays.copyOfRange(arr,start,mid+1);
        int[] arr2=Arrays.copyOfRange(arr,mid+1,end+1);
        int i=0;
        int j=0;
        int k=start;
        while(i<arr1.length&&j<arr2.length){
            if(arr1[i]<=arr2[j]){
                arr[k]=arr1[i++];
            }
            else{
                arr[k]=arr2[j++];
            }
            k++;
        }
        while(i<arr1.length){
            arr[k++]=arr1[i++];
        }
         while(j<arr2.length){
            arr[k++]=arr2[j++];
        }
    }
    public static void merge_Sort(int[] arr,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            merge_Sort(arr,start,mid);
            merge_Sort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
	public static void mergeSort(int[] input){
		// Write your code here
		merge_Sort(input,0,input.length-1);
	}
}

