//Palindromic Substrings
//
//Given a string S, count and return the number of substrings of S that are palindrome.
//Single length substrings are also palindromes. You just need to calculate the count, not the substrings.
//Input Format :
//String S
//Output Format :
//count of palindrome substrings
//Constraints :
//1 <= Length of S <= 1000
//Sample Input :
//aba
//Sample Output :
//4
//**Note : Here 4 corresponds to ("a","b","a","aba").

public class PalindromeSubstrings {

    public static int countPalindromeSubstrings(String s) {
        // Write your code here
        int count = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < str.length && str[l] == str[r]) {
                count++;
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < str.length && str[l] == str[r]) {

                count++;
                l--;
                r++;
            }

        }

        return count;
    }
}
