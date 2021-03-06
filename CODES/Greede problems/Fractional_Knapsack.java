//Fractional Knapsack
//
//You want to paint your house. The total area of your house is D units. There are a total of N workers. The ith worker is available after time Ti, has hiring cost Xi and speed Yi. This means he becomes available for hiring from time Ti and remains available after that. Once available, you can hire him with cost Xi, after which he will start painting the house immediately, covering exactly Yi units of house with paint per time unit. You may or may not hire a worker and can also hire or fire him at any later point of time. However, no more than 1 worker can be painting the house at a given time.
//Since you want the work to be done as fast as possible, figure out a way to hire the workers, such that your house gets painted at the earliest possible time, with minimum cost to spend for hiring workers.
//Note: You can hire a previously hired worker without paying him again.
//Input
//The first line of input contains two integers "N D", the number of workers and the area of your house respectively. The ith of the next N lines denotes the ith worker, and contains three integers "Ti Xi Yi", described in the statement.
//Output
//Output one integer, the minimum cost that you can spend in order to get your house painted at the earliest.
//Constraints
//1 ≤ N, T, X, Y ≤ 10^5
//1 ≤ D ≤ 10^11
//Sample Input
//3 3
//1 1 1
//2 2 2
//3 1 5
//Sample Output
//3


import java.util.*;
import java.math.*;
class comp implements Comparator<worker>{
    public int compare(worker a,worker b){
        if(a.time==b.time){
            if(a.speed==b.speed){
                return (int)(a.cost-b.cost);
            }
            return (int)(a.speed-b.speed);
        }
        return (int)(a.time-b.time);
    }
}
class worker{
    public float avg;
    public long time;
    public long cost;
    public long speed;
    worker(long time,long cost,long speed){
        this.time=time;
        this.cost=cost;
        this.speed=speed;
        avg=(float)speed;
    }
    
}
public class Main {

	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        long worker=in.nextLong();
        long hunit=in.nextLong();
        ArrayList<worker> lst=new ArrayList<>();
        for(int i=0;i<worker;i++)
            lst.add(new worker(in.nextInt(),in.nextInt(),in.nextInt() ) );
      
        Collections.sort(lst,new comp());
        long cost=0;
        long tunit=0;
        int last=0;
        for(int i=0;i<worker;i++){
            worker a=lst.get(i);
            if(tunit+a.speed<=hunit){
                cost+=a.cost;
                tunit+=a.speed;
            }
            else{
                float x=hunit-tunit;
                cost+=a.cost*(x/a.speed);
                last=i;
                break;
            }
            last=i;
            
        }
        System.out.println(cost);
        cost=0;
        int xx=0;
        for(worker i:lst){
            if(xx>=last)
                break;
            xx++;
            cost+=i.cost;
            
        }
	}

}