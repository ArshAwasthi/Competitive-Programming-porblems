//Even and Odd Indexes

//Given an array of integers, print two integer values:
//First, the sum of all numbers which are even as well as whose index are even.
//Second, the sum of all numbers which are odd as well as whose index are odd.
//Print the two integers space separated. (Arrays is 0-indexed)

//Input:
//Given an integer denoting the size of array.
//Next line will have a line containing ‘n’ space separated integers.

//Constraints:
//1<=n<=10^5
//1 <= Ai <= 10^6 

//Output:
//Two space separated integers denoting even and odd sums respectively.

//Sample Input:
//5
//2 3 5 1 4

//Sample Output:
//6 4

package practice;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size=in.nextInt();
        
        if(size>0){
            int even=0;
            int odd=0;
            int[] arr=new int[size];
            for(int i=0;i<size;i++){
                arr[i]=in.nextInt();
            }
            for(int i=0;i<size;i++){
                if(i%2==0&&arr[i]%2==0)
                    even+=arr[i];
                else if(i%2!=0&&arr[i]%2!=0)
                    odd+=arr[i];
            }
            System.out.println(even+" "+odd);
        }
	}
}