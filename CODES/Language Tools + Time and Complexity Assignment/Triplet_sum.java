//Triplet sum
//
//Given a random integer array and a number x. Find and print the triplets of elements in the array which sum to x.
//While printing a triplet, print the smallest element first.
//That is, if a valid triplet is (6, 5, 10) print "5 6 10". There is no constraint that out of 5 triplets which have to be printed on 1st line. You can print triplets in any order, just be careful about the order of elements in a triplet.
//Input format :
//Line 1 : Integer N (Array Size)
//Line 2 : Array elements (separated by space)
//Line 3 : Integer x
//Output format :
//Line 1 : Triplet 1 elements (separated by space)
//Line 2 : Triplet 3 elements (separated by space)
//Line 3 : and so on
//Constraints :
//1 <= N <= 1000
//1 <= x <= 100
//Sample Input:
//7
//1 2 3 4 5 6 7 
//12
//Sample Output ;
//1 4 7
//1 5 6
//2 3 7
//2 4 6
//3 4 5

import java.util.*;
public class TripletSum {	
	public static void FindTriplet(int[] arr, int x){
		int[] trip=new int[3];
        Arrays.sort(arr);
        for(int i=0;i<arr.length&&arr[i]<=x;i++){
            if(arr[i]<x)
            {
                boolean flag=false;
                trip[0]=arr[i];
                int sec=i+1;
                while(sec<arr.length){
                    if(arr[sec]+arr[i]<x){
                        trip[1]=arr[sec];
                        int thr=sec+1;
                        while(thr<arr.length){
                            if(arr[thr]+arr[sec]+arr[i]==x){
                                trip[2]=arr[thr];
                                 System.out.print(trip[0]);
                    System.out.print(" "+trip[1]);
                                 System.out.println(" "+trip[2]);
                                flag=true;
                                }
                                
                             thr++;
                            }
                           
                        }
                    sec++;
                    }
                    if(flag){
                trip=new int[3];
                    
                }
                
                }
            }
            }
        }
	