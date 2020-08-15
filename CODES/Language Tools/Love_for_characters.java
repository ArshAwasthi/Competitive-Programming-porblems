//Love for Characters
//
//Ayush loves the characters ‘a’, ‘s’, and ‘p’. He got a string of lowercase letters and he wants to find out how many times characters ‘a’, ‘s’, and ‘p’ occurs in the string respectively. Help him find it out.
//Input:
//First line contains an integer denoting length of the string.
//Next line contains the string.
//Constraints:
//1<=n<=10^5
//‘a’<= each character of string <= ‘z’
//Output:
//Three space separated integers denoting the occurrence of letters ‘a’, ‘s’ and ‘p’ respectively.
//Sample Input:
//6
//aabsas
//Sample output:
//3 2 0

import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size=in.nextInt();
        if(size>0){
            String input=in.next();
            HashMap<Character,Integer> map=new HashMap<>();
            map.put('a',0);
            map.put('s',0);
            map.put('p',0);
            for(int i=0;i<size;i++){
                Character ch=input.charAt(i);
                if(map.containsKey(ch))
                    map.put(ch,map.get(ch)+1);
            }
            System.out.print(map.get('a')+" "+map.get('s')+" "+map.get('p'));
        }
	}
}