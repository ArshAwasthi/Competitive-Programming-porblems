//Activity Selection
//
//You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
//Input
//The first line of input contains one integer denoting N.
//Next N lines contains two space separated integers denoting the start time and finish time for the ith activity.
//
//Output
//Output one integer, the maximum number of activities that can be performed
//Constraints
//1 ≤ N ≤ 10^6
//1 ≤ ai, di ≤ 10^9
//Sample Input
//6
//1 2
//3 4
//0 6
//5 7
//8 9
//5 9
//Sample Output
//4

import java.util.*;
import javafx.util.*;
class comp implements Comparator<Pair<Integer,Integer>>{
    public int compare(Pair<Integer,Integer> a,Pair<Integer,Integer> b){
        return a.getValue()-b.getValue();
    }
}
public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int size=in.nextInt();
        ArrayList<Pair<Integer,Integer>> lst=new ArrayList<>();
        for(int i=0;i<size;i++){
            int start=in.nextInt();
            int end=in.nextInt();
            lst.add(new Pair(start,end));
        }
        Collections.sort(lst,new comp());
        int maxact=0;
         int ps=0;
       int pe=0;
        for(int i=0;i<lst.size();i++){
            Pair<Integer,Integer> a=lst.get(i);
            if(i==0){
                maxact++;
                pe=a.getValue();
                continue;
            }
            if(a.getKey()>=pe){
                maxact++;
                pe=a.getValue();
            }
        }
    
        System.out.println(maxact);
	}

}