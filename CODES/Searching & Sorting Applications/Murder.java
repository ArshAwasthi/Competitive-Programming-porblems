//Murder
//
//Once detective Saikat was solving a murder case. While going to the crime scene he took the stairs and saw that a number is written on every stair. He found it suspicious and decides to remember all the numbers that he has seen till now. While remembering the numbers he found that he can find some pattern in those numbers. So he decides that for each number on the stairs he will note down the sum of all the numbers previously seen on the stairs which are smaller than the present number. Calculate the sum of all the numbers written on his notes diary.
//Answer may not fit in integer . You have to take long.
//Input
//First line gives T, number of test cases.
//
//2T lines follow.
//
//First line gives you the number of stairs N
//
//Next line gives you N numbers written on the stairs.
//Output
//For each test case output one line giving the final sum for each test case.
//Constraints
//T<=10
//
//1<=N<=10^5
//
//All numbers will be between 0 and 10^6.
//Sample Input:
//1
//5
//1 5 3 6 4
//Sample Output:
//15
//Explanation:
//For the first number, the contribution to the sum is 0.
//For the second number, the contribution to the sum is 1.
//For the third number, the contribution to the sum is 1.
//For the fourth number, the contribution to the sum is 9 (1+5+3).
//For the fifth number, the contribution to the sum is 4 (1+3).
//Hence the sum is 15 (0+1+1+9+4).

import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
        Scanner in=new Scanner(System.in);
        int cases=in.nextInt();
        if(cases>0){
            for(int c=0;c<cases;c++){
                int size=in.nextInt();
                if(size>0){
                    long sum=0;
                    int[] arr=new int[size];
                    for(int i=0;i<size;i++){
                        arr[i]=in.nextInt();
                        for(int j=0;j<i;j++){
                            if(arr[j]<arr[i])
                                sum+=arr[j];
                        }
                    }
                    System.out.println(sum);
                }
                else
                    System.out.println(0);
                
            }
        }
        
	}

}