//Distribute Candies
//
//Shaky has N (1<=N<=50000) candy boxes each of them contains a non-zero number of candies (between 1 and 1000000000). Shaky want to distibute these candies among his K (1<=K<=1000000000) IIIT-Delhi students. He want to distibute them in a way such that:
//1. All students get equal number of candies.
//2. All the candies which a student get must be from a single box only.
//As he want to make all of them happy so he want to give as many candies as possible. Help Shaky in finding out what is the maximum number of candies which a student can get.
//Input
//First line contains 1<=T<=20 the number of test cases. Then T test cases follow. First line of each test case contains N and K. Next line contains N integers, ith of which is the number of candies in ith box.
//Output
//For each test case print the required answer in a seperate line.
//Sample Input:
//2
//3 2 
//3 1 4
//4 1
//3 2 3 9
//Sample Output:
//3
//9

import java.util.*;

public class Main {

	public static boolean check(int[] arr,int candies,int students){
        int count=0;
        for(int i=0;i<arr.length;i++){
            count+=(arr[i]/candies);
        }
        return (count<students)?false:true;
    }
	public static void main(String[] args) {
		// Write your code here
        Scanner in=new Scanner(System.in);
        int cases=in.nextInt();
        if(cases>0){
            for(int j=0;j<cases;j++){
            int size=in.nextInt();
            int students=in.nextInt();
            int[] arr=new int[size];
            int sum=0;
            int max=0;
            for(int i=0;i<size;i++){
                arr[i]=in.nextInt();
                sum+=arr[i];
                if(max<arr[i])
                    max=arr[i];
            }
           
          int a=1;
          int b=max;
          int mid=0;
          int min=0;
          while(a<=b){
              mid=(a+b)/2;
              if(check(arr,mid,students)){
                  a=mid+1;
                  min=mid;
              }
              else{
                  b=mid-1;
              }
          }
        System.out.println(min);
       
        }
        }
	}

}