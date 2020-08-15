//Different Names

//In Little Flowers Public School, there are many students with same first names. You are given a task to find the students with same names. You will be given a string comprising of all the names of students and you have to tell the name and count of those students having same. If all the names are unique, print -1 instead.
//Note: We don't have to mention names whose frequency is 1.
//Input Format:
//The only line of input will have a string ‘str’ with space separated first names of students.
//Output Format:
//Print the names of students along with their count if they are repeating. If no name is repeating, print -1
//Constraints:
//1 <= |str| <= 10^5
//Time Limit: 1 second
//Sample Input 1:
//Abhishek harshit Ayush harshit Ayush Iti Deepak Ayush Iti
//Sample Output 1:
//harshit 2
//Ayush 3
//Iti 2
//Sample Input 2:
//Abhishek Harshit Ayush Iti
//Sample Output:
//-1
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap();
        while (in.hasNext()) {
            String name = in.next();
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }
        boolean flag = false;
        for (String i : map.keySet()) {
            if (map.get(i) > 1) {
                System.out.println(i + " " + map.get(i));
                flag = true;
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }

}
