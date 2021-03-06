//Maximum Pair Sum
//
//You are given a sequence A[1], A[2], ..., A[N], ( 0 ≤ A[i] ≤ 10^8 , 2 ≤ N ≤ 10^5 ). There are two types of operations and they are defined as follows:
//Update:
//This will be indicated in the input by a 'U' followed by space and then two integers i and x.
//U i x, 1 ≤ i ≤ N, and x, 0 ≤ x ≤ 10^8.
//This operation sets the value of A[i] to x.
//Query:
//This will be indicated in the input by a 'Q' followed by a single space and then two integers i and j.
//Q x y, 1 ≤ x < y ≤ N.
//You must find i and j such that x ≤ i, j ≤ y and i != j, such that the sum A[i]+A[j] is maximized. Print the sum A[i]+A[j].
//Input
//The first line of input consists of an integer N representing the length of the sequence. 
//Next line consists of N space separated integers A[i]. Next line contains an integer Q, Q ≤ 10^5, representing the number of operations. Next Q lines contain the operations.
//Output
// Output the maximum sum mentioned above, in a separate line, for each Query.
//Input:
//5
//1 2 3 4 5
//6
//Q 2 4
//Q 2 5
//U 1 6
//Q 1 5
//U 1 7
//Q 1 5
//Output:
//7
//9
//11
//12

import java.util.*;
import java.math.*;
class node{
    public int min;
    public int max;
    node(int a,int b)
    {
        min=a;
        max=b;
    }
    node(){
        
    }
}
public class Main {

	public static void build(int[] arr,node[] segment,int start,int end,int i){
        if(start==end)
        {
            segment[i].max=arr[start];
            segment[i].min=Integer.MIN_VALUE;
            return;
        }
        int mid=(start+end)/2;
        build(arr,segment,start,mid,2*i);
        build(arr,segment,mid+1,end,2*i+1);
        segment[i].max=Math.max(segment[2*i].max,segment[2*i+1].max);
        segment[i].min=Math.min(Math.max(segment[2*i].max,segment[2*i+1].min) ,Math.max(segment[2*i].min,segment[i*2+1].max));
    }
    
    
    public static void update(int[] arr,node[] segment,int start,int end,int i,int index,int value){
        if(start==end)
        {
            segment[i].max=value;
            arr[start]=value;
            return;
        }
        int mid=(start+end)/2;
        if(index>mid){
            //right side
            update(arr,segment,mid+1,end,2*i+1,index,value);
        }
        else
        {
            //left side
            update(arr,segment,start,mid,2*i,index,value);
        }
        node left=segment[i*2];
        node right=segment[i*2+1];
        segment[i].max=Math.max(left.max,right.max);
        segment[i].min=Math.min(Math.max(left.min ,right.max ) , Math.max( right.min,left.max ));
    }
    
    public static node query(int[] arr,node[] segment,int start,int end,int i,int from,int to){
        if(from<=start&&to>=end){
            return segment[i];
        }
        else if(to<start||from>end){
            return new node(Integer.MIN_VALUE,Integer.MIN_VALUE);
        }
        int mid=(start+end)/2;
        node left=query(arr,segment,start,mid,2*i,from,to);
        node right=query(arr,segment,mid+1,end,2*i+1,from,to);
        int min=Math.min(Math.max(left.min ,right.max ) , Math.max( right.min,left.max ));
        int max=Math.max(left.max,right.max);
        node x=new node(min,max);
        return x;
    }
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int size=Integer.parseInt(in.next());
        int[] arr=new int[size];
        node[] segment=new node[size*3];
        for(int i=0;i<size;i++)
         arr[i]=Integer.parseInt(in.next());
        for(int i=0;i<segment.length;i++)
            segment[i]=new node();
        int queries=Integer.parseInt(in.next());
        build(arr,segment,0,arr.length-1,1);
        for(int i=0;i<queries;i++){
            char q=in.next().charAt(0);
            if(q=='Q'){
                int from=Integer.parseInt(in.next());
                int to=Integer.parseInt(in.next());
                //call()
                node x=query(arr,segment,0,arr.length-1,1,from-1,to-1);
            
                System.out.println(x.max+x.min);
            }
            else{
                int index=Integer.parseInt(in.next());
                int value=Integer.parseInt(in.next());
               // call()
                update(arr,segment,0,arr.length-1,1,index-1,value);
            }
        }
	}

}