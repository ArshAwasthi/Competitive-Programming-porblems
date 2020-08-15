//Tell the positions

//In a class there are ‘n’ number of students. They have three different subjects: Data Structures, Algorithm Design & Analysis and Operating Systems. Marks for each subject of all the students are provided to you. You have to tell the position of each student in the class. Print the names of each student according to their position in class. Tie is broken on the basis of their roll numbers. Between two students having same marks, the one with less roll number will have higher rank. The input is provided in order of roll number.
//Input Format:
//First line will have a single integer ‘n’, denoting the number of students in the class.
//Next ‘n’ lines each will have one string denoting the name of student and three space separated integers m1, m2, m3 denoting the marks in three subjects.
//Output Format:
//Print ‘n’ lines having two values: First, the position of student in the class and second his name.
//Constraints:
//1 <= n <= 10^5
//0 <= m1, m2, m3 <= 100
//Sample Input:
//3
//Mohit 94 85 97
//Shubham 93 91 94
//Rishabh 95 81 99
//Sample Output:
//1 Shubham
//2 Mohit
//3 Rishabh


import java.util.*;
import javafx.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//Vector v=new Vector();
        ArrayList<student> v=new ArrayList<student>();
        int size=in.nextInt();
        for(int i=0;i<size;i++){
            String name=in.next();
            int marks=in.nextInt()+in.nextInt()+in.nextInt();
            v.add(new student(name,marks));
        }
        Collections.sort(v,new comp());
        int i=1;
        for(student n:v){
            System.out.println(i+" "+n.getName());
            i++;
        }
	}
}
class comp implements Comparator<student>{
    public int compare(student a,student b){
        if(a.marks==b.marks)
            return 0;
        if(a.marks<b.marks)
            return 1;
        return -1;
    }
}
class student{
   public String name;
    int marks;
    student(String a,int b){
        name=a;
        marks=b;
    }
    public String getName(){
        return name;
    }
}