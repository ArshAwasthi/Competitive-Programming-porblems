//Angry Children
//
//Bill Gates is on one of his philanthropic journeys to a village in Utopia. He has N packets of candies and would like to distribute one packet to each of the K children in the village (each packet may contain different number of candies). To avoid a fight between the children, he would like to pick K out of N packets such that the unfairness is minimized.
//Suppose the K packets have (x1, x2, x3,....xk) candies in them, where xi denotes the number of candies in the ith packet, then we define unfairness as
//unfairness=0;
//for(i=0;i<n;i++)
//for(j=0;j<n;j++)
//    unfairness+=abs(xi-xj)
//abs(x) denotes absolute value of x.
//Input Format
//The first line contains an integer N.
//The second line contains an integer K.
//N lines follow each integer containing the candy in the ith packet.
//Output Format
//A single integer which will be minimum unfairness.
//Constraints
//2<=N<=10^5
//
//2<=K<=N
//
//0<= number of candies in each packet <=10^9
//Sample Input
//7
//3
//10
//100
//300
//200
//1000
//20
//30
//Sample Output
//40
//Explanation
//Bill Gates will choose packets having 10, 20 and 30 candies.So unfairness will be |10-20| + |20-30| + |10-30| = 40. We can verify that it will be minimum in this way.


import java.util.*;
import java.math.*;
public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        long[] arr=new long[n];
        long[] dp=new long[n];
        long min=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            arr[i]=in.nextLong();
        }
        Arrays.sort(arr);
      
        int start=0;
		long sum=0;
        dp[1]=arr[1]-arr[0];
        if(k<2){
          System.out.println( dp[k]);
            return;
        }
        sum=arr[0]+arr[1];
        for(int i=2;i<n;i++){
            if(i<k){
            dp[i]=dp[i-1]+((i*arr[i])-sum);
         
            }
            else{
                sum-=arr[start];
                dp[i]=dp[i-1]-(2*sum)+((k-1)*arr[start])+((k-1)*arr[i]);
            
        }
            sum+=arr[i];
               if(i>=k)
                start++;   
        if(i>=k-1)
        if(min>dp[i])
    		min=dp[i];
		}
       
			System.out.println(min);
				}
                               }