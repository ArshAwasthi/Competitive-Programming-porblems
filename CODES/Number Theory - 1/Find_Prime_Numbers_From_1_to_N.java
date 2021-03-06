//Find Prime Numbers From 1 to N
//
//Given a number N, find number of primes in the range [1,N].
//Input:
//The only line of input consists of a number N
//Output:
//Print the number of primes in the range [1,N].`
//Constraints:
//1≤N≤1000000
//Sample Input :
//3 
//Sample Output -
//2

import java.util.*;
import java.math.*;

public class Main {

    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = n - 1;
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, 2, arr.length, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i]) {
                boolean flag = true;
                for (int j = 2; j <= (int) (i / 2); j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {

                    for (int j = i; (j * i) < arr.length; j++) {
                        if (arr[j * i]) {
                            count--;
                            arr[j * i] = false;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num = 0;

        System.out.println(countPrimes(n));
    }

}
