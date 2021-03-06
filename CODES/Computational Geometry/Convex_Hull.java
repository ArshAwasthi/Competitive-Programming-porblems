//Convex Hull
//
//Given a set of points in the plane. the convex hull of the set is the smallest convex polygon that contains all the points of it.
//Find out the convex hull for the given set of points.
//Input Format
//Integer N(Number Of points)
//Array of X coordinates
//Array of Y coordinates
//Output Format
//X coordinate and Y coordinate of all the points seperated by space. Order doesn't matter.
//Sample Testcase
//Input
//7
//2 1 6 5 3 7 9
//2 5 1 5 7 6 4
//Output
//1 5
//2 2
//6 1
//9 4
//7 6
//3 7

import java.util.*;
class point{
    public int x;
    public int y;
}
public class Main {
	public static boolean getangle(point p,point q,point r){
    	int x1=q.x-p.x;
        int y1=q.y-p.y;
        int x2=r.x-q.x;
        int y2=r.y-q.y;
        int angle=x1*y2-y1*x2;
        return angle>0;
    }
    public static void convexHull(point points[], int n) 
    { 
        if (n < 3) return; 
        Vector<point> hull = new Vector<point>(); 
        int l = 0; 
        for (int i = 1; i < n; i++) 
            if (points[i].x < points[l].x) 
                l = i; 
    
        int p = l, q; 
        do
        {
            hull.add(points[p]); 
            q = (p + 1) % n; 
            for (int i = 0; i < n; i++) 
            { 
           
               if (getangle(points[p], points[i], points[q]) ) 
                   q = i; 
            } 
            p = q; 
       
        } while (p != l);  
        for (point temp : hull) 
            System.out.println( temp.x + " " + temp.y ); 
    } 
    
	public static void jarvis(point[] arr){
        if(arr.length<3)
            return ;
        int left=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i].x<arr[left].x)
                left=i;
        }
        Vector<point> v=new Vector<>();
        int p=left,q;
        do{
            v.add(arr[p]);
             q=(p+1)%arr.length;
            for(int r=0;r<arr.length;r++){
                if(getangle(arr[p],arr[r],arr[q])){
                    q=r;
                }
            }
            p=q;
        }while(p!=left);
        
        for(point i:v){
            System.out.println(i.x+" "+i.y);
        }
    }
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int size=in.nextInt();
        point[] arr=new point[size];
        for(int i=0;i<size;i++){
            arr[i]=new point();
            arr[i].x=in.nextInt();;
        }
        for(int i=0;i<size;i++){
        	arr[i].y=in.nextInt();
        }
        jarvis(arr);
	}
    
    
}