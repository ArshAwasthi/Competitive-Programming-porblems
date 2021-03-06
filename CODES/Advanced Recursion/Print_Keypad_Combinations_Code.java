//Print Keypad Combinations Code
//
//Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
//Note : The order of strings are not important. Just print different strings in new lines.
//Input Format :
//Integer n
//Output Format :
//All possible strings in different lines
//Constraints :
//1 <= n <= 10^6
//Sample Input:
//23
//Sample Output:
//ad
//ae
//af
//bd
//be
//bf
//cd
//ce
//cf


import java.util.*;
public class solution {
    static HashMap<Integer,String[]> map=new HashMap<>();
    static{
        map.put(2,new String[]{"a","b","c"});
        map.put(3,new String[]{"d","e","f"});
        map.put(4,new String[]{"g","h","i"});
        map.put(5,new String[]{"j","k","l"});
        map.put(6,new String[]{"m","n","o"});
        map.put(7,new String[]{"p","q","r","s"});
        map.put(8,new String[]{"t","u","v"});
        map.put(9,new String[]{"w","x","y","z"});
        
    }
    public static void print(int input,String str){
        if(input==0)
        {
            System.out.println(str);
            return ;
        }
        for(String ch:map.get(input%10)){
            print(input/10,ch+str);
        }
    
    }
	public static void printKeypad(int input){
		// Write your code here
		print(input,"");
	}
}
