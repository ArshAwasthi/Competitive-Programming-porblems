//Weighted Job Scheduling
//
//You are given N jobs where every job is represented as:
//1.Start Time
//2.Finish Time
//3.Profit Associated
//Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
//Input
//The first line of input contains one integer denoting N.
//Next N lines contains three space separated integers denoting the start time, finish time and the profit associated with the ith job. 
//Output
//Output one integer, the maximum profit that can be achieved.
//Constraints
//1 ≤ N ≤ 10^6
//1 ≤ ai, di, p ≤ 10^6
//Sample Input
//4
//3 10 20
//1 2 50
//6 19 100
//2 100 200
//Sample Output
//250

import java.util.*;
class job{
    int stime;
    int etime;
    int profit;
    job(int start,int end,int profit){
        stime=start;
        etime=end;
        this.profit=profit;
    }
}
class way implements Comparator<job>{
    @Override
    public int compare(job a,job b){
        return a.etime-b.etime;
    }
}

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
        Scanner in=new Scanner(System.in);
        int size=in.nextInt();
        job[] lst=new job[size];
        int[] endtime=new int[size];
        for(int i=0;i<size;i++){
            int start=in.nextInt();
            int end=in.nextInt();
            int profit=in.nextInt();
            endtime[i]=end;
            lst[i]=new job(start,end,profit);
            
        }
        Arrays.sort(endtime);
        Arrays.sort(lst,new way());
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            if(i==0)
                arr[i]=lst[0].profit;
            else{
            	  int iprofit=lst[i].profit;
                if(lst[i].stime<lst[0].etime){
                    arr[i]=Math.max(iprofit,arr[i-1]);
                    continue;
                }
                 int doing=0;
               if(lst[i].stime>=lst[0].etime){
                     int index=Arrays.binarySearch(endtime, lst[i].stime);
                if(index<0){
                    
                    index=Math.abs(index)-1;	//get value next grater
                	if(index>0&&lst[index-1].etime<=lst[i].stime){
                        index--;
                    	doing=arr[index];
                    }
                   
                }
                else{
                    doing=arr[index];
                }
               }
                int not_doing=arr[i-1];
               doing+=lst[i].profit;
               
                arr[i]=Math.max(doing,not_doing);
            }
        }
        System.out.println(arr[arr.length-1]);

	}

}