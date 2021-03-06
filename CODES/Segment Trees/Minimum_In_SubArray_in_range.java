//Minimum In SubArray
//
//Range Minimum Query
//Given an array A of size N, there are two types of queries on this array.
//1) q l r: In this query you need to print the minimum in the sub-array A[l:r].
//2) u x y: In this query you need to update A[x]=y.
//Input:
//First line of the test case contains two integers, N and Q, size of array A and number of queries.
//Second line contains N space separated integers, elements of A.
//Next Q lines contain one of the two queries.
//Output:
//For each type 1 query, print the minimum element in the sub-array A[l:r].
//Contraints:
//1≤N,Q,y≤10^5
//1≤l,r,x≤N
//Sample Input :
//5 5
//1 5 2 4 3
//q 1 5
//q 1 3
//q 3 5
//u 3 6
//q 1 5
//Sample Output :
//1
//1
//2
//1

import java.util.*;
import java.math.*;
public class Main {

	public static void build(int[] arr,int[] segment,int start,int end,int i){
        if(start==end)
        {
            segment[i]=arr[start];
            return ;
        }
        int mid=(start+end)/2;
        build(arr,segment,start,mid,2*i);
        build(arr,segment,mid+1,end,2*i+1);
        segment[i]=Math.min(segment[2*i],segment[2*i+1]);
    }
    public static void update(int[] arr,int[] segment,int start,int end,int i,int index,int value){
        if(start==end)
        {

            segment[i]=value;
            arr[index]=value;
            return;
        }
        int mid=(start+end)/2;
        if(index>mid){
            update(arr,segment,mid+1,end,2*i+1,index,value);
        }
        else{
            update(arr,segment,start,mid,2*i,index,value);
        }
        segment[i]=Math.min(segment[2*i],segment[2*i+1]);
    }
    
    public static int query(int[] arr,int[] segment,int start,int end,int i,int from,int to){
        if(to>=end&&from<=start)
            return segment[i];
        else if(from>end||to<start)
            return Integer.MAX_VALUE;
        int mid=(start+end)/2;
        int a=query(arr,segment,start,mid,2*i,from,to);
        int b=query(arr,segment,mid+1,end,2*i+1,from,to);
        return Math.min(a,b);
    }
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int size=Integer.parseInt(in.next());
        int queries=Integer.parseInt(in.next());
        int[] arr=new int[size];
        int[] segment=new int[size*4];
        for(int i=0;i<size;i++)
            arr[i]=Integer.parseInt(in.next());
        build(arr,segment,0,arr.length-1,1);
        for(int i=0;i<queries;i++){
            char q=in.next().charAt(0);
            if(q=='q'){
                int from=Integer.parseInt(in.next());
                int to=Integer.parseInt(in.next());
                System.out.println(query(arr,segment,0,arr.length-1,1,from-1,to-1));
            }
            else{
                int index=Integer.parseInt(in.next());
                int value=Integer.parseInt(in.next());
                update(arr,segment,0,arr.length-1,1,index-1,value);
            }
        }
	}

}