//GCD
//
//Calculate and return GCD of two given numbers x and y. Numbers are within range of Integer.
//Input format :
//x and y (separated by space)
//Output format :
//GCD of x and y
//Sample Input 1:
//20 
//5
//Sample Output 1:
//5
//Sample Input 2:
//96 
//14
//Sample Output 2:
//2

import java.math.BigInteger;

public class Solution {

    public static int gcd(int a, int b) {
        BigInteger aa = new BigInteger(a + "");
        BigInteger ba = new BigInteger(b + "");
        return Integer.parseInt(aa.gcd(ba).toString());
    }
}
