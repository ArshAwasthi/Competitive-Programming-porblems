//String Search
//
//Given two strings S and T, write a function to find if T is present as a substring inside S or not. If yes, return the starting index otherwise return -1.
//Input format :
//
//Line 1 : String S
//
//Line 2 : String T
//
//Sample Input 1:
//WelcomeBack
//come 
//Sample Output 1:
//3
//Sample Input 2:
//WelcomeBack
//code
//Sample Output 2:
//-1


public class Solution {

    public static void longest_preffix_suffix(String str, int[] arr) {
        if (str.length() <= 1) {
            return;
        }
        int j = 0;
        int i = 1;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                arr[i++] = ++j;

            } else {
                if (j != 0) {
                    j = arr[j - 1];
                } else {
                    arr[i++] = j++;

                }
            }
        }
    }

    public static int findString(String text, String pattern) {
        // Write your code here
        int[] arr = new int[pattern.length()];
        longest_preffix_suffix(pattern, arr);
        int i = 0;
        int j = 0;
        int index = -1;

        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    return index;
                }
                if (index == -1) {
                    index = i;
                }
                i++;
                j++;
            } else {
                index = -1;
                if (j != 0) {
                    j = arr[j = 1];
                } else {
                    i++;
                }
            }
        }
        return index;
    }
}
