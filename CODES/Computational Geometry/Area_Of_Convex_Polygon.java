//Area Of Convex Polygon
//
//A convex polygon is a set of n vertices that are joined by n edges, such that no two edges intersect and all angles are less than 180 degrees. We can represent a polygon by listing all the vertices, starting at one vertex and following the edges until that vertex is reached again. Thus, element 0 in the array represents the first vertex. The first vertex is connected to the second vertex (element 1), the second vertex is connected to the third vertex (element 2) and so on. The last element represents the last vertex, which is connected to the first vertex.
//Given the vertices of a polygon, where the x-coordinate of vertex i is element i of int[] x and its y-coordinate is element i of int[] y, return its exact area.
//Input Format
// Integer N
// Two arrays x and y of size N
//Output Format
//Area of polygon
//Notes
//Get the integer part of the area. (It can be long)
//So get your answer in double, and typecast it into long.
//Constraints
//x and y will have the same number of elements.
//x will have between 3 and 50 elements inclusive.
//y will have between 3 and 50 elements inclusive.
//each element in x will be between -10000 and 10000 inclusive.
//each element in y will be between -10000 and 10000 inclusive.
//the represented polygon will NOT intersect itself.
//the represented polygon will NOT have any angles equal to or greater than 180 degrees.
//Sample Input
//3
//0 0 1
//0 1 0
//Sample Output
//0
//(Exact area was 0.5 . In Integer It is 0)


import java.util.*;
import java.math.*;
class point{
    public double x;
    public double y;
    
}
class polygon{
    public point[] p;
    polygon(int size){
        p=new point[size];
    }
}
public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int size=in.nextInt();
        polygon poly=new polygon(size);
        for(int i=0;i<size;i++){
            poly.p[i]=new point();
            poly.p[i].x=in.nextInt();
        }
         for(int i=0;i<size;i++){
         poly.p[i].y=in.nextInt();
         }
        double area=0;
        double x=poly.p[0].x;
        double y=poly.p[0].y;
        for(int i=1;i<size-1;i++){
            double x1=poly.p[i].x-x;
            double y1=poly.p[i].y-y;
            double x2=poly.p[i+1].x-x;
            double y2=poly.p[i+1].y-y;
            area+=(x1*y2-y1*x2);
        }
        area=Math.abs(area/2);
        System.out.println((long)area);
	}

}