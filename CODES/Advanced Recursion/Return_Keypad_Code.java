//Return Keypad Code
//
//Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
//Return empty string for numbers 0 and 1.
//Note : 1. The order of strings are not important.
//2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.
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
	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){
		// Write your code here
        String str=String.valueOf(n);
        if(str.length()<=1){
        if(n<10&&n>=2)
            return map.get(n);
        if(n<2||String.valueOf(n).charAt(0)=='0')
            return new String[]{""};
        }
        
        String[] out=keypad(Integer.parseInt(str.substring(1,str.length())));
        String[] ch=map.get(Integer.parseInt(str.charAt(0)+""));
        String[] tempout=new String[out.length*ch.length];
         for(int i=0;i<ch.length;i++){
           System.arraycopy(out,0,tempout,i*out.length,out.length);
            
            for(int j=0;j<out.length;j++){
                tempout[(i*out.length)+j]=ch[i]+tempout[(i*out.length)+j];
            }
        }
       return tempout;
	}
	
}
