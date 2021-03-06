//Counting Strings
//
//Given a string 's' consisting of upper case alphabets, i.e. from 'A' to 'Z'. Your task is to find how many strings 't' with length equal to that of 's', also consisting of upper case alphabets are there satisfying the following conditions:
//-> String 't' is lexicographical larger than string 's'.
//-> When you write both 's' and 't' in the reverse order, 't' is still lexicographical larger than 's'.
//Find out number of such strings 't'. As the answer could be very large, take modulo 10^9 + 7.


import java.util.*;
import java.math.*;

public class Solution {

    public static long countStrings(String str) {

        String input = str;
        int m = (int) Math.pow(10, 9) + 7;
        long ans = 0;
        long prev = 0;
        for (char i : input.toCharArray()) {
            ans += ((prev + 1) % m) * ((int) 'Z' - (int) i);
            prev = (26 * prev) % m + ((int) 'Z' - (int) i);
        }
        return ans % m;
    }

}
