//Warm Reception

//There is only one beauty parlour in the town CodingNinjasLand. The receptionist at the beauty parlor is flooded with appointment requests because the “Hakori” festival is round the corner and everyone wants to look good on it.
//She needs your help. The problem is they don’t have chairs in reception. They are ordering chairs from NinjasKart. They don’t want to order more than required. You have to tell the minimum number of chairs required such that none of the customers has to stand.
//Input Format :
//First line contains the number of customers that will come. Second line contains N space-separated integers which represent the arrival timings of the customer. Third line contains N space-separated integers which represent the departure timings of the customer. Arrival and departure timings are given in 24-hour clock.
//Constraints:
//1<= N <= 100
//Arrival and departure timings lie in the range [0000 to 2359]
//Time Limit: 1 second
//Output Format :
//You have to print the minimum number of chairs required such that no customer has to wait standing. 
//Sample Test Cases:
//Sample Input 1 :
//5
//900 1000 1100 1030 1600
//1900 1300 1130 1130 1800
//Sample Output 1:
//4
//Explanation:
//4 because at 1100 hours, we will have maximum number of customers at the shop, throughout the day. And that maximum number is 4. 

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        Scanner in = new Scanner(System.in);
        int customers = in.nextInt();
        Vector arrive = new Vector();
        Vector departure = new Vector();
        int seats = 0;
        for (int i = 0; i < customers; i++) {
            arrive.add(in.nextInt());
        }
        for (int i = 0; i < customers; i++) {
            departure.add(in.nextInt());
        }
        //selection sort
        for (int i = 0; i < arrive.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrive.size(); j++) {
                if ((int) arrive.elementAt(j) < (int) arrive.elementAt(min)) {
                    min = j;
                }
            }
            if (min != i) {
                int temp1 = (int) arrive.elementAt(i);
                int temp2 = (int) departure.elementAt(i);
                arrive.set(i, (int) arrive.elementAt(min));
                departure.set(i, (int) departure.elementAt(min));
                arrive.set(min, temp1);
                departure.set(min, temp2);
            }
        }

        //seat filling
        for (int i = 0; i < arrive.size(); i++) {

            if (i == 0) {
                seats++;
            } else {
                int vacent = getmin(departure, (int) arrive.elementAt(i), i - 1);
                if (vacent == -1) {
                    seats++;
                } else {
                    arrive.remove(vacent);
                    departure.remove(vacent);
                    i--;
                }
            }
        }
        System.out.print(seats);
    }

    public static int getmin(Vector a, int arrive, int range) {
        for (int i = 0; i <= range; i++) {
            if ((int) a.elementAt(i) <= arrive) {
                return i;
            }
        }
        return -1;
    }
}
