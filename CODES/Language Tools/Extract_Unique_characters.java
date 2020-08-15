//Extract Unique characters

//Given a string, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same.
//Input format :
//String S
//Output format :
//Output String
//Constraints :
//0 <= Length of S <= 10^8
//Sample Input 1 :
//ababacd
//Sample Output 1 :
//abcd
//Sample Input 2 :
//abcde
//Sample Output 2 :
//abcde



import java.util.*;

public class solution {

	public static String uniqueChar(String str){
		// Write your code here
        String output="";
        HashSet<Character> set=new HashSet<>();
        char[] input=str.toCharArray();
        for(int i=0;i<input.length;i++){
            if(set.add(input[i]))
               output+=input[i];
        }
        return output;
	}
}

