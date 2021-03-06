//Winning Lottery
//
//Harshit knows by his resources that this time the winning lottery number is the smallest number whose sum of the digits is S and the number of digits is D. You have to help Harshit and print the winning lottery number.
//Input Format
//The Input line contains two space-separated integers: S,D
//Output Format
//The output contains a single integer denoting the winning lottery number
//Constraints
//1 <= D <= 1000
//1 <= S <= 9*D
//Time Limit: 1 second
//Sample Input1:
//9 2
//Sample Output1:
//18
//Explanation
//There are many other possible numbers like 45, 54, 90, etc with the sum of digits as 9 and number of digits as 2. The smallest of them is 18.


import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
        int sum=in.nextInt();
        int digits=in.nextInt();
        int[] arr=new int[digits];
        int remaining=sum/digits;
        Arrays.fill(arr,0,arr.length,remaining);
        int rem=sum-1;
        String str="";
        for(int i=1;i<digits;i++){
            if(rem==0)
                str="0"+str;
            else{
                if(rem>=9){
                    str="9"+str;
                rem-=9;
                }
                else{
                    str=rem+str;
                rem=0;
                }
            }
            
        }
        rem++;
        System.out.println(rem+str);
	}

}