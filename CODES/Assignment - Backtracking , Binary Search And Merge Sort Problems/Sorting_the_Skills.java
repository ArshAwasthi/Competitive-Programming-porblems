//Sorting the Skills
//
//There is a company named James Peterson & Co. The company has ‘n’ employees. The employees have skills from 0 to n-1. All the employees have distinct skills. The manager of James Peterson & Co. wants to sort the employees on the basis of their skills in ascending order. He is only allowed to swap two employees which are adjacent to each other. He is given the skills of employees in an array of size ‘n’. He can swap the skills as long as the absolute difference between their skills is 1. You need to help the manager out and tell whether it is possible to sort the skills of employees or not.
//Input Format:
//First Line will have an integer ‘t’ denoting the no. of test cases.
//First line of each test case contains an integer ‘n’ denoting the no. of employees in the company.
//Second line of each test case contains ‘n’ distinct integers in the range [0, n-1].
//Output Format:
//For each test case, print “Yes” if it is possible to sort the skills otherwise “No”.
//Constraints:
//1 <= t <= 10
//1 <= n <= 10^5
//Sample Input:
//2
//4
//1 0 3 2
//3
//2 1 0
//Sample Output:
//Yes
//No
//Explanation:
//In first T.C., [1, 0, 3, 2] -> [0, 1, 3, 2] -> [0, 1, 2, 3]
//In second T.C., [2, 1, 0] -> [1, 2, 0]  OR  [2, 1, 0] -> [2, 0, 1] So, it is impossible to sort.

import java.util.*;
import java.math.*;
public class Main {
    public static boolean sort(int[] arr){
        if(arr.length<=1)
            return true;
        boolean x=false;
        if(arr[0]>arr[1])
        {
            if(arr[0]-arr[1]>1)
            return false;
            int temp=arr[0];
            arr[0]=arr[1];
            arr[1]=temp;
        }
        x= sort(Arrays.copyOfRange(arr,1,arr.length));
        if(arr[0]<=arr[1]&&x==true)
            x=true;
            return x;
    }
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases=in.nextInt();
        for(int i=0;i<cases;i++){
            int size=0;
            if(in.hasNext()){
            size=in.nextInt();
            int[] arr=new int[size];
            for(int j=0;j<size;j++)
                arr[j]=in.nextInt();
           boolean x=true;
                for(int j=0;j<arr.length-1;j++){
                    if(arr[j]>arr[j+1]){
                        if(arr[j]-arr[j+1]>1)
                        {
                            x=false;
                        	break;
                        }
                        int temp=arr[j];
            			arr[j]=arr[j+1];
            			arr[j+1]=temp;
                        
                    }
                }
                
                if(x)
                System.out.println("Yes");
            else
                System.out.println("No");
            }
            else
                System.out.println("Yes");
        }
	}
}