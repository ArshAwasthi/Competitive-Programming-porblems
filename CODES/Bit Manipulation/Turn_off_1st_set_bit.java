//Turn off 1st set bit
//
//You are given an integer Ni. You need to make first set bit of binary representation of N to 0 and return the updated N.
//Counting of bits start from 0 from right to left.
//Input Format :
//Integer N 
//Output Format :
//Updated N
//Sample Input 1 :
//4
//Sample Output 1 :
//0
//Sample Input 2 :
//12 
//Sample Output 2 :
//8

public class Solution {
	public static int turnOffFirstSetBit(int n) {
		//Your code goes here
         if(n==0)
            return 0;
        int count=0;
        int t=n;
        while((t&1)==0&&n>0){
            count++;
            t=t>>1;
        }
        return n&(~(1<<count));
	}
}