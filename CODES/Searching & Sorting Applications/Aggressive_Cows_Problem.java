//Aggressive Cows Problem
//
//Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
//His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
//Input
//t – the number of test cases, then t test cases follows. 
//* Line 1: Two space-separated integers: N and C
//* Lines 2..N+1: Line i+1 contains an integer stall location, xi
//Output
//For each test case output one integer: the largest minimum distance.
//Sample Input :
//1
//5 3
//1
//2
//8
//4
//9
//Sample Output:
//3 
//Output details:
//FJ can put his 3 cows in the stalls at positions 1, 4 and 8, 
//resulting in a minimum distance of 3.


import java.util.*;
import java.math.*;

public class Main {

    public static boolean isArrange(int[] arr, int cows, int distance) {
        if (cows == 1 && arr.length > 0) {
            return true;
        }
        boolean result = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[0] >= distance) {
                result = isArrange(Arrays.copyOfRange(arr, i, arr.length), --cows, distance);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //Write your code here
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int loop = 0; loop < cases; loop++) {
            int stalls = in.nextInt();
            int cows = in.nextInt();
            if (stalls > 0 && cows > 0) {
                int[] arr = new int[stalls];
                for (int i = 0; i < stalls; i++) {
                    arr[i] = in.nextInt();
                }
                Arrays.sort(arr);
                int min = 0;
                int max = arr[arr.length - 1] - arr[0];
                int dist = 0;
                int mid = 0;
                int i = 0;
                while (min <= max) {
                    mid = (min + max) / 2;

                    if (isArrange(arr, cows, mid)) {
                        dist = mid;
                        min = mid + 1;
                    } else {
                        max = mid - 1;
                    }
                    i++;
                }
                System.out.println(dist);
            }
        }
    }

}
