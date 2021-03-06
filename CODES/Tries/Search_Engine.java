//Search Engine
//
//Let us see how search engines work. Consider the following simple auto complete feature. When you type some characters in the text bar, the engine automatically gives best matching options among it's database. Your job is simple. Given an incomplete search text, output the best search result.
//Each entry in engine's database has a priority factor attached to it. We consider a result / search suggestion best if it has maximum weight and completes the given incomplete search query. For each query in the input, print the maximum weight of the string in the database, that completes the given incomplete search string. In case no such string exists, print -1.
//INPUT
//First line contains two integers n and q, which represent number of database entries and number of search queries need to be completed. Next n lines contain a string s and an integer weight, which are the database entry and it's corresponding priority.
//
//Next q lines follow, each line having a string t, which needs to be completed.
//OUTPUT
//Output q lines, each line containing the maximum possible weight of the match for given query, else -1, in case no valid result is obtained.
//CONSTRAINTS
//1 ≤ n, weight, len(s), len(t) ≤ 10^6
//1 ≤ q ≤ 10^5
//total length of all strings in database entries ≤ 10^6
//total length of all query strings ≤ 10^6
//SAMPLE INPUT
//2 1
//hackerearth 10
//hackerrank 9
//hacker
//SAMPLE OUTPUT
//10


import java.util.*;
import java.math.*;
class node{
    node[] child;
    int weight;
    node(){
        child=new node[26];
        for(int i=0;i<26;i++)
            child[i]=null;
    }
}
public class Main {
	public static void insert(node head,String input,int weight){
        if(input.length()<=0)
            return;
        int index=input.charAt(0)-'a';
        node cur=head;
        if(head.child[index]!=null){
            cur=head.child[index];
        }
        else
        {
            head.child[index]=new node();
            cur=head.child[index];
        }
        if(head.weight<weight)
            head.weight=weight;
        insert(cur,input.substring(1,input.length()),weight);
    }
    
	public static int search(node head,String input){
        int max=0;
        node cur=head;
        for(int i=0;i<input.length();i++){
            int index=input.charAt(i)-'a';
            node child=cur.child[index];
            if(child!=null){
                max=child.weight;
                cur=child;
                
            }
            else{
                return -1;
            }
        }
        //serarch
        return max;
    }
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int inputs=Integer.parseInt(in.next());
        int queries=Integer.parseInt(in.next());
        node head=new node();
        for(int i=0;i<inputs;i++)
        {
            String word=in.next();
            int weight=Integer.parseInt(in.next());
			insert(head,word,weight);
            //inserting inputs
        }
        for(int i=0;i<queries;i++){
            String input=in.next();
            System.out.println(search(head,input));
        }
	}

}