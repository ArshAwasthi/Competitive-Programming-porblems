//Momos Market
//
//Shreya loves to eat momos. Her mother gives her money to buy vegetables but she manages to save some money out of it daily. After buying vegetables, she goes to "Momos Market", where there are ‘n’ number of shops of momos. Each of the shops of momos has a rate per momo. She visits the market and starts buying momos (one from each shop) starting from the first shop. She will visit the market for ‘q’ days. You have to tell that how many momos she can buy each day if she starts buying from the first shop daily. She cannot use the remaining money of one day on some other day. But she will save them for other expenses in the future, so, you also need to tell the sum of money left with her at the end of each day.
//Input Format:
//First line will have an integer ‘n’ denoting the number of shops in market.
//Next line will have ‘n’ numbers denoting the price of one momo of each shop.
//Next line will have an integer ‘q’ denoting the number of days she will visit the market.
//Next ‘q’ lines will have one integer ‘X’ denoting the money she saved after buying vegetables.
//Constraints:
//1 <= n <= 10^5
//1 <= q <= 10^5
//1 <= X <= 10^9
//Output:
//There will be ‘q’ lines of output each having two space separated integers denoting number of momos she can buy and amount of money she saved each day.
//Sample Input:
//4
//2 1 6 3
//1
//11
//Sample Output:
//3 2
//Explanation:
//Shreya visits the "Momos Market" for only one day. She has 11 INR to spend. She can buy 3 momos, each from the first 3 shops. She would 9 INR (2 + 1 + 6) for the same and hence, she will save 2 INR.


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int shops = in.nextInt();
        int[] arr = new int[shops];
        for (int i = 0; i < shops; i++) {
            if (i == 0) {
                arr[i] = in.nextInt();
            } else {
                arr[i] = arr[i - 1] + in.nextInt();
            }
        }

        System.out.println();
        int saving = 0;
        int shop = 0;
        int days = in.nextInt();
        for (int i = 0; i < days; i++) {
            //get money and print market traveled and money saved
            int money = in.nextInt();
            if (arr[0] > money) {
                System.out.println(0 + " " + money);
            } else if (arr[0] == money) {
                System.out.println(1 + " " + 0);
            } else {
                int loc = Arrays.binarySearch(arr, money);
                if (loc < 0) {
                    System.out.println(Math.abs(loc) - 1 + " " + Math.abs(money - arr[Math.abs(loc) - 2]));
                } else {
                    System.out.println((loc + 1) + " " + Math.abs(money - arr[loc]));
                }
            }
        }
    }
}
