//Perimeter with conditions
//
//Aahad gives an array of integers and asks Harshit to find which three elements form a triangle (non-degenerate). The task seems easy to Harshit.
//So, Aahad adds some conditions to this task -
//1. Find the triangle with maximum perimeter
//2. If there are two or more combinations with same value of maximum perimeter, then find the one with the longest side.
//3.If there are more than one combinations which satisfy all the above conditions the find with maximum longest minimum side.
//Input Format
//The First line contains no of elements of array: N
//Each T lines contains N space-separated integers: A [i]
//Output Format
//The output contains three space-separated elements that denote the length of the sides of triangle. If no such triangle is possible, then print -1.
//Constraints
//1 =< N <= 10^5 
//1 <= A[i] <= 10^9
//Time Limit: 1 second
//Sample Input1:
//5
//1 1 1 3 3
//Sample Output1:
//1 3 3 
//Sample Input2:
//3
//2 2 4
//Sample Output3:
//-1 
//Explaination
//In the First Sample case, the elements that form a triangle with maximum perimeter is 1,3,3.
//In the Second Sample case, the elements that can form a triangle are degenerate, so, we printed -1.

import java.util.*;
import java.math.*;
public class Main {
    public static void solve(int[] arr,int[] ract,int a,int m,int b,long maxperi){
        if(a!=b&&b!=m&&a!=m){
          int max=Math.max(arr[a],Math.max(arr[b],arr[m]));
            int peri=arr[a]+arr[m]+arr[b];
            if(max<(peri-max)&&peri>=maxperi){
                if(peri==maxperi){
                    int longside=Math.max(ract[0],Math.max(ract[1],ract[0]));
                    if(longside<max){
                    maxperi=(long)peri;
                    ract[0]=arr[a];
                    ract[1]=arr[m];
                    ract[2]=arr[b];
                    }
                    
                }
                else{
                    maxperi=(long)peri;
                    ract[0]=arr[a];
                    ract[1]=arr[m];
                    ract[2]=arr[b];
                }
            
            }
            solve(arr,ract,a,(a+m)/2,m,maxperi);
            solve(arr,ract,m,(m+b)/2,b,maxperi);
          
        }
    }
    public static void main(String[] args) {
        // Write your code here
        Scanner in=new Scanner(System.in);
        int size=in.nextInt();
        int[] arr=new int[size];
        int[] out=new int[3];
        for(int i=0;i<size;i++){
            arr[i]=in.nextInt();
        }
        Arrays.fill(out,0,out.length,-1);
        Arrays.sort(arr);
        int start=0;
        int end=size-1;
        int mid=(start+end)/2;
        solve(arr,out,start,mid,end,Long.MIN_VALUE);
        for(int i=0;i<out.length;i++){
            System.out.print(out[i]+" ");
        }
    }
    
}
