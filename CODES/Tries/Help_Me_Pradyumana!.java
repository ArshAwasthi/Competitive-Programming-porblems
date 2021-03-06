//Help Me Pradyumana!
//
//Pradyumn is tired of using auto - correct feature in his smartphone. He needs to correct his auto - correct more times than the auto - correct corrects him. Pradyumn is thinking to make his own app for mobile which will restrict auto - correct feature, instead it will provide auto - completion. Whenever Pradyumn types factorial, auto - correct changes it to fact. Pradyumn's App will show options such as fact, factorial, factory. Now, he can chose from any of these options. As Pradyumn is busy with his front - end work of his App. He asks you to help him. He said "You will be given set of words(words may repeat too but counted as one only). Now, as user starts the app, he will make queries(in lowercase letters only). So, you have to print all the words of dictionary which have the prefix same as given by user as input. And if no such words are available, add this word to your dictionary." As you know, Pradyumn want this app to be as smart as him :P So, implement a program for him such that he can release it on Fun Store.
//INPUT CONSTRAINTS
//1≤N≤30000
//sum(len(string[i]))≤2∗10^5
//1≤Q≤10^3
//INPUT FORMAT
//Single integer N which denotes the size of words which are input as dictionary
//N lines of input, where each line is a string of consisting lowercase letter
//Single integer Q which denotes the number of queries.
//Q number of lines describing the query string on each line given by user
//OUTPUT FORMAT
//If auto - completions exists, output all of them in lexicographical order else output "No suggestions" without quotes
//
//NOTE: All strings are lowercase
//SAMPLE INPUT
//3
//fact
//factorial
//factory
//2
//fact
//pradyumn
//SAMPLE OUTPUT
//fact
//factorial
//factory
//No suggestions


import java.util.*;

class node {

    node[] child;
    boolean end;

    node() {
        child = new node[26];
    }
}

public class Main {

    public static void DFS(node head, String pre) {
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if (head.child[i] != null) {
                //  flag=true;
                node child = head.child[i];
                if (child.end) {
                    System.out.println(pre + (char) (i + 'a'));
                }
                DFS(head.child[i], (pre + (char) (i + 'a')));
            }
        }
    }

    public static void insert(node head, String str) {
        if (str.length() <= 0) {
            return;
        }
        node cur = head;
        int index = str.charAt(0) - 'a';
        if (head.child[index] != null) {
            cur = head.child[index];
        } else {
            head.child[index] = new node();
            cur = head.child[index];
            if (str.length() == 1) {
                cur.end = true;
            }
        }
        insert(cur, str.substring(1, str.length()));
    }

    public static void comb(node head, String str) {
        node cur = head;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            node child = cur.child[index];
            if (child != null) {
                cur = child;
            } else {
                System.out.println("No suggestions");
                return;
            }
        }
        if (cur.end) {
            System.out.println(str);
        }
        DFS(cur, str);
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner in = new Scanner(System.in);
        int inputs = Integer.parseInt(in.next());
        node head = new node();
        for (int i = 0; i < inputs; i++) {
            //input next string
            insert(head, in.next());
        }
        int queries = Integer.parseInt(in.next());
        for (int i = 0; i < queries; i++) {
            //call for comb
            String input = in.next();
            comb(head, input);
            insert(head, input);
        }
    }

}
