//Coder's Rating
//
//Some of the more elite (and not-so-elite) coders around take part in a certain unnamed programming contest. In said contest, there are multiple types of competitions. Here, we consider the Open and High School competition types. For each type, each competitor receives a rating, an integer between 1 and 100000, inclusive. A coder's rating is based upon his or her level of performance in matches and is calculated using a complicated formula which, thankfully, you will not be asked to implement.
//Although the Open and High School ratings for a coder who has participated in both competition types lately are usually close, this is not always the case. In particular, High School matches are more about speed, since many coders are able to solve all the problems, whereas Open matches require more thinking and there is a steeper curve in terms of problem difficulty.
//Problem Statement
//You are given N coders (1 ≤ N ≤ 300000), conveniently numbered from 1 to N. Each of these coders participates in both High School and Open matches. For each coder, you are also given an Open rating Ai and a High School rating Hi. Coder i is said to be better than coder j if and only if both of coder i's ratings are greater than or equal to coder j's corresponding ratings, with at least one being greater. For each coder i, determine how many coders coder i is better than.
//Input Format
//On the first line of input is a single integer N, as described above. N lines then follow. Line i+1 contains two space-separated integers, Ai and Hi.
//Output Format
// Line i should contain the number of coders that coder i is better than.
//Sample Input
//8
//1798 1832
//862 700
//1075 1089
//1568 1557
//2575 1984
//1033 950
//1656 1649
//1014 1473
//Sample Output
//6
//0
//2
//4
//7
//1
//5
//1

import java.util.*;

class coder {

    public int x, y, index;

    coder() {

    }

    coder(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

class way implements Comparator<coder> {

    @Override
    public int compare(coder a, coder b) {
        return (a.x == b.x) ? a.y - b.y : a.x - b.x;
    }
}

public class Main {

    public static void update(int[] BIT, int y) {
        for (; y <= 100000; y += (y & (-y))) {
            BIT[y]++;
        }
    }

    public static int query(int[] BIT, int y) {
        int output = 0;

        for (; y > 0; y -= (y & (-y))) {
            output += BIT[y];
        }

        return output;
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        coder[] arr = new coder[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new coder(in.nextInt(), in.nextInt(), i);
        }
        Arrays.sort(arr, new way());
        int[] BIT = new int[100001];
        int[] output = new int[size];
        for (int i = 0; i < size;) {
            int index = i;
            while (index < size && arr[i].x == arr[index].x && arr[i].y == arr[index].y) {
                index++;
            }
            for (int j = i; j < index; j++) {
                output[arr[j].index] = query(BIT, arr[j].y);
            }
            for (int j = i; j < index; j++) {
                update(BIT, arr[j].y);
            }
            i = index;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(output[i]);
        }

    }

}
