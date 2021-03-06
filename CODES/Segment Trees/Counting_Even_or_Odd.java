//Counting Even/Odd
//
//Ashu and Shanu are best buddies. One day Shanu gives Ashu a problem to test his intelligence.He gives him an array of N natural numbers and asks him to solve the following queries:-
//Query 0 :- modify the element present at index i to x.
//Query 1:- count the number of even numbers in range l to r inclusive.
//Query 2:- count the number of odd numbers in range l to r inclusive.
//Input:
//First line of the input contains the number N. Next line contains N natural numbers. 
//Next line contains an integer Q followed by Q queries.
//
//0 x y - modify the number at index x to y. 
//
//1 x y - count the number of even numbers in range l to r inclusive.
//
//2 x y - count the number of odd numbers in range l to r inclusive.
//Constraints:
//1<=N,Q<=10^5
//
//1<=l<=r<=N 
//
//0<=Ai<=10^9
//
//1<=x<=N
//
//0<=y<=10^9
//Note:-
//indexing starts from 1.
//Sample Input
//6
//1 2 3 4 5 6
//4
//1 2 5
//2 1 4
//0 5 4
//1 1 6
//Sample Output
//2
//2
//4

import java.util.*;
class node{
    public long even;
    public long odd;
}
public class Main {

	public static void build(long[] arr,node[] segment,int start,int end,int i){
      
        if(start==end){
            
            if((arr[start]&1)==0)
                segment[i].even++;
            else 
                segment[i].odd++;
            return;
        }
		int mid=(start+end)/2;
        build(arr,segment,start,mid,2*i);
        build(arr,segment,mid+1,end,2*i+1);
        segment[i].even=segment[i*2].even+segment[i*2+1].even;
        segment[i].odd=segment[i*2].odd+segment[i*2+1].odd;
    }
    public static void update(long[] arr,node[] segment,int start,int end,int i,int index,long value){
        if(start==end){
            arr[start]=value;
            if((arr[start]&1)==0)
            {
             segment[i].even=1;
             segment[i].odd=0;
            }
            else {
             segment[i].even=0;
             segment[i].odd=1;
            }
            return;
        }
        int mid=(start+end)/2;
        if(index>mid)
        	update(arr,segment,mid+1,end,2*i+1,index,value);
        else
            update(arr,segment,start,mid,2*i,index,value);
        segment[i].even=segment[i*2].even+segment[i*2+1].even;
        segment[i].odd=segment[i*2].odd+segment[i*2+1].odd;
    }
    public static node query(long[] arr,node[] segment,int start,int end,int i,int from,int to){
        if(start>=from&&end<=to){
            return segment[i];
        }
        if(start>to||end<from){
            return new node();
        }
        int mid=(start+end)/2;
    	node left=query(arr,segment,start,mid,2*i,from,to);
        node right=query(arr,segment,mid+1,end,2*i+1,from,to);
        node out=new node();
        out.even=left.even+right.even;
        out.odd=left.odd+right.odd;
        return out;
        
    }
        
        
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int size=in.nextInt();
        long[] arr=new long[size];
        node[] segment=new node[size*4];
        for(int i=0;i<size*4;i++){
             segment[i]=new node();
        }
        for(int i=0;i<size;i++)
            arr[i]=in.nextLong();
        build(arr,segment,0,arr.length-1,1);
        
    
        int cases=in.nextInt();
        for(int i=0;i<cases;i++){
            int action=in.nextInt();
            long a=in.nextLong();
            long b=in.nextLong();
            if(action==0){
                //updation
                a--;
                update(arr,segment,0,arr.length-1,1,(int)a,b);
            }
            else
            {
                a--;
                b--;
                node x=query(arr,segment,0,arr.length-1,1,(int)a,(int)b);
            if(action==1){
                //even
                System.out.println(x.even);
            }
            else{
                //odd
                System.out.println(x.odd);
            }
            }
        }
	}

}