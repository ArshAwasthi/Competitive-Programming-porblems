//Inversion Count
//
//Let A[0 ... n-1] be an array of n distinct positive integers. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A (where i and j are indexes of A). Given an integer array A, your task is to find the number of inversions in A.
//Input format :
//Line 1 : n, array size
//Line 2 : Array elements (separated by space).
//Output format :
//Count of inversions
//Constraints :
//1 <= n <= 10^5
//1 <= A[i] <= 10^9
//Sample Input 1 :
//3
//3 2 1
//Sample Output 1 :
//3
//Sample Input 2 :
//5
//2 5 1 3 4
//Sample Output 1 :
//4


import java.util.*;
import java.math.*;
class solution{
    public static long merge(int[] arr,int low,int mid,int high){
        long count=0;
        int lowsize=mid-low+1;
        int highsize=high-mid;
        int[] lowarr=Arrays.copyOfRange(arr,low,mid+1);
        int[] higharr=Arrays.copyOfRange(arr,mid+1,high+1);
        Arrays.sort(lowarr);
        Arrays.sort(higharr);
        int i=0;
        int j=0;
        while(i<lowarr.length&&j<higharr.length){
            if(lowarr[i]<=higharr[j]){
                i++;
            }
            else if(higharr[j]<lowarr[i]){
               count+=lowarr.length-i;
               j++;
           }
        }
       return count;
    }
public static long merge_sort(int[] arr,int low,int high){
long count=0;
    if(low<high){
       int mid=(low+high)/2;
        
      long count1=merge_sort(arr,low,mid);
       long count2=merge_sort(arr,mid+1,high);
       count=merge(arr,low,mid,high);
        return count1+count2+count;
    }
    return count;
}
    public long solve(int[] arr,int size){
         
     doub count=merge_sort(arr,0,size-1);
          return count;
    }
    
}

