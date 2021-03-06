//Calculate Grundy Number
//
//Calculate the Grundy Number for the given 'n' in the game.
//The game starts with a number- ‘n’ and the player to move divides the number- ‘n’ with 2, 3 or 6 and then takes the floor. If the integer becomes 0, it is removed. The last player to move wins. Which player wins the game?
//Input Format
//An Integer 'n'
//Output Format
//Grundy Number(n)
//Sample Input 1 -
//10
//Sample Output 1-
//0

import java.util.*;

public class Main {
	public static int mex(Set<Integer> s){
        int out=0;
        for(int i=0;i<s.size();i++){
            if(!s.contains(out))
                break;
            out++;
        }
        return out;
    }
	public static int grundy(int num){
        if(num==0)
            return 0;
        Set<Integer> s=new HashSet<>();
        s.add(grundy(num/2));
        s.add(grundy(num/3));
        s.add(grundy(num/6));
        return mex(s);
    }
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        System.out.println(grundy(num));
	}

}