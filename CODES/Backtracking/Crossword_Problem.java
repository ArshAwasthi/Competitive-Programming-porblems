//Crossword Problem
//
//CodingNinjas has provided a crossword of 10*10 grid. The grid contains '+' or '-' as its cell values. Now, you are also provided with a word list that needs to placed accurately in the grid. Cells marked with '-' are to be filled with word list.
//For example, The following is an example for the input crossword grid and the word list.
//+-++++++++
//+-++-+++++
//+-------++
//+-++-+++++
//+-++-+++++
//+-++-+++++
//++++-+++++
//++++-+++++
//++++++++++
//----------
//CALIFORNIA;NIGERIA;CANADA;TELAVIV
//Output for the given input should be:
//+C++++++++
//+A++T+++++
//+NIGERIA++
//+A++L+++++
//+D++A+++++
//+A++V+++++
//++++I+++++
//++++V+++++
//++++++++++
//CALIFORNIA
//Note: We have provided such test cases that there is only one solution for the given input.
//Input format:
//The first 10 lines of input contain crossword. Each of 10 lines has a character array of size 10. Input characters are either '+' or '-'.
//The next line of input contains the word list, in which each word is separated by ';'. 
//Output format:
//Print the crossword grid, after placing the words of word list in '-' cells.  
//Sample Test Cases:
//Sample Input 1:
//+-++++++++
//+-++-+++++
//+-------++
//+-++-+++++
//+-++-+++++
//+-++-+++++
//++++-+++++
//++++-+++++
//++++++++++
//----------
//CALIFORNIA;NIGERIA;CANADA;TELAVIV
//Sample Output 1:
//+C++++++++
//+A++T+++++
//+NIGERIA++
//+A++L+++++
//+D++A+++++
//+A++V+++++
//++++I+++++
//++++V+++++
//++++++++++
//CALIFORNIA

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] crossword = new char[10][];
        for (int i = 0; i < crossword.length; i++) {
            crossword[i] = scn.nextLine().toCharArray();
        }
        String[] words = scn.nextLine().split(";");
        solve(crossword, words, 0);
    }

    private static void solve(char[][] crossword, String[] words, int vidx) {
        if (vidx == words.length) {
            print(crossword);
            return;
        }
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (crossword[r][c] == '-' || crossword[r][c] == words[vidx].charAt(0)) {
// try vertical 
                    if (IsValidVertical(crossword, r, c, words[vidx]) == true) {
                        boolean[] resetHelper = new boolean[words[vidx].length()];
                        setVertically(crossword, r, c, words[vidx], resetHelper);
                        solve(crossword, words, vidx + 1);
                        resetVertically(crossword, r, c, words[vidx], resetHelper);
                    }
// try horizontal 
                    if (IsValidHorizontal(crossword, r, c, words[vidx]) == true) {
                        boolean[] resetHelper = new boolean[words[vidx].length()];
                        setHorizontally(crossword, r, c, words[vidx], resetHelper);
                        solve(crossword, words, vidx + 1);
                        resetHorizontally(crossword, r, c, words[vidx], resetHelper);
                    }
                }
            }
        }
    }
//to place the words vertically 

    private static void setVertically(char[][] crossword, int r, int c, String word, boolean[] resetHelper) {
        for (int rdash = r; rdash < r + word.length(); rdash++) {
            resetHelper[rdash - r] = crossword[rdash][c] == '-';
            crossword[rdash][c] = word.charAt(rdash - r);
        }
    }
//to reset the crossword 

    private static void resetVertically(char[][] crossword, int r, int c, String word, boolean[] resetHelper) {
        for (int rdash = r; rdash < r + word.length(); rdash++) {
            if (resetHelper[rdash - r] == true) {
                crossword[rdash][c] = '-';
            }
        }
    }
//to check the validness of vertical placement of words

    private static boolean IsValidVertical(char[][] crossword, int r, int c, String word) {
        for (int rdash = r; rdash < r + word.length(); rdash++) {
            if (rdash == 10) {
                return false;
            } else if (crossword[rdash][c] == '+') {
                return false;
            } else if (crossword[rdash][c] != '-') {
                if (crossword[rdash][c] != word.charAt(rdash - r)) {
                    return false;
                }
            }
        }
        return true;
    }
//to place the words horizontally

    private static void setHorizontally(char[][] crossword, int r, int c, String word, boolean[] resetHelper) {
        for (int cdash = c; cdash < c + word.length(); cdash++) {
            resetHelper[cdash - c] = crossword[r][cdash] == '-';
            crossword[r][cdash] = word.charAt(cdash - c);
        }
    }
//to reset the crossword 

    private static void resetHorizontally(char[][] crossword, int r, int c, String word, boolean[] resetHelper) {
        for (int cdash = c; cdash < c + word.length(); cdash++) {
            if (resetHelper[cdash - c] == true) {
                crossword[r][cdash] = '-';
            }
        }
    }
//to check the validness of horizontal placement of words

    private static boolean IsValidHorizontal(char[][] crossword, int r, int c, String word) {
        for (int cdash = c; cdash < c + word.length(); cdash++) {
            if (cdash == 10) {
                return false;
            } else if (crossword[r][cdash] == '+') {
                return false;
            } else if (crossword[r][cdash] != '-') {
                if (crossword[r][cdash] != word.charAt(cdash - c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print(char[][] crossword) {
        for (int r = 0; r < crossword.length; r++) {
            for (int c = 0; c < crossword[r].length; c++) {
                System.out.print(crossword[r][c]);
            }
            System.out.println();
        }
    }
}
