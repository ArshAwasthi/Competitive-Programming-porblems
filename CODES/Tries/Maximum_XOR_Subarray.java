//Maximum XOR Subarray
//
//Given an array of n integers, find subarray whose xor is maximum.
//Input Format
//First line contains single integer n (1<=n<=1000000).
//Next line contains n space separated integers.
//Output Format
//Print xor of the subarray whose xor of all elements in subarray is maximum over all subarrays.
//Constraints
//1 <= n <= 1000000
//1 <= A[i] <=100000 
//Sample Input
//4
//1 2 3 4
//Sample Output
//7

import java.util.*;
import java.math.*;

class node {

    node left;
    node right;

    node() {
        left = right = null;
    }

    node(node l, node r) {
        left = l;
        right = r;
    }
}

public class Main {

    //only build trie
    public static void insert(node head, int value) {
        node cur = head;
        for (int i = 31; i >= 0; i--) {
            int bit = (value >> i) & 1;
            if (bit == 0) {
                if (cur.left == null) {
                    cur.left = new node();
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new node();
                }
                cur = cur.right;
            }
        }
    }

    public static int max_xor(node head, int[] arr, int index) {
        int max = 0;
        node cur = head;
        int val = arr[index];
        int cxor = 0;
        for (int j = 31; j >= 0; j--) {
            int bit = (val >> j) & 1;
            if (bit == 0) {
                if (cur.right != null) {
                    cxor += Math.pow(2, j);
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.left != null) {
                    cxor += Math.pow(2, j);
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
        }
        return cxor;
    }

    public static int max_sub_xor(int[] arr) {
        int cmax = 0;
        node head = new node();
        int[] buffer = new int[arr.length];
        insert(head, arr[0]);
        for (int i = 1; i < arr.length; i++) {
            buffer[i] = arr[i] ^ buffer[i - 1];
            insert(head, buffer[i]);
            int max = max_xor(head, buffer, i);
            if (max > cmax) {
                cmax = max;
            }
        }
        return cmax;
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(max_sub_xor(arr));
    }

}
